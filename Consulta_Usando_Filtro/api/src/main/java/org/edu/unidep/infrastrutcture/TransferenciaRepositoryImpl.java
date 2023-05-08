package org.edu.unidep.infrastrutcture;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.edu.unidep.domain.filter.TransferenciaFilter;
import org.edu.unidep.domain.model.Transferencia;
import org.edu.unidep.domain.repository.TransferenciaRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class TransferenciaRepositoryImpl implements TransferenciaRepository, PanacheRepository<Transferencia>{
	
	@Override
	public List<Transferencia> getWithFilter(TransferenciaFilter filter) {
		
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		
		CriteriaQuery<Transferencia> query = criteriaBuilder.createQuery(Transferencia.class);
		
		Root<Transferencia> root = query.from(Transferencia.class);
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(Transferencia.class.equals(query.getResultType())) {
			root.fetch("conta");
		}
		
		if(filter.getContaId() != null) {
			predicates.add(criteriaBuilder.equal(root.get("conta"), filter.getContaId()));
		}
			
		if(filter.getDataCriacaoInicio() != null) {
			predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dataTransferencia"), filter.getDataCriacaoInicio()));
		}
		
		if(filter.getDataCriacaoFim() != null) {
			predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dataTransferencia"), filter.getDataCriacaoFim()));
		}
		
		if(filter.getNomeOperador() != null && !filter.getNomeOperador().equals("")) {
			predicates.add(criteriaBuilder.equal(root.get("nomeOperador"), filter.getNomeOperador()));
		}
		
		
		query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
		
		TypedQuery<Transferencia> queryResult = getEntityManager().createQuery(query);
		
		return queryResult.getResultList();
	}
	
}
