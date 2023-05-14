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
	public List<Transferencia> getWithFilter(TransferenciaFilter transferenciaFilter) {
		
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Transferencia> query = criteriaBuilder.createQuery(Transferencia.class);
		Root<Transferencia> root = query.from(Transferencia.class);
		List<Predicate> predicates = new ArrayList<>();
		
		if(Transferencia.class.equals(query.getResultType())) {
			root.fetch("conta");
		}
		
		if(transferenciaFilter.getDataTransferenciaInicio() != null) {
			predicates.add(criteriaBuilder
					.greaterThanOrEqualTo(root.get("dataTransferencia"),
							transferenciaFilter.getDataTransferenciaInicio()));
		}
		
		if(transferenciaFilter.getDataTransferenciaFim() != null) {
			predicates.add(criteriaBuilder
					.lessThanOrEqualTo(root.get("dataTransferencia"),
							transferenciaFilter.getDataTransferenciaFim()));
		}
		
		if(transferenciaFilter.getNomeOperador() != null && !transferenciaFilter.getNomeOperador().equals("")) {
			predicates.add(criteriaBuilder.equal(root.get("nomeOperador"), transferenciaFilter.getNomeOperador()));
		}
		
		if(transferenciaFilter.getContaId() != null) {
			predicates.add(criteriaBuilder.equal(root.get("conta"), transferenciaFilter.getContaId()));
		}
		
		query.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
		
		TypedQuery<Transferencia> queryResult = getEntityManager().createQuery(query);
		
		return queryResult.getResultList();
	}

	
}
