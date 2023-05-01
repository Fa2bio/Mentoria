package org.edu.unidep.infrastrucute.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.edu.unidep.api.command.CategoriaCommand;
import org.edu.unidep.domain.model.Categoria;
import org.edu.unidep.domain.repository.CategoriaRepository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CategoriaImpl implements PanacheRepository<Categoria>,
        CategoriaRepository {
    @Override
    public List<Categoria> listarCategorias() {
        return listAll();
    }

    @Override
    public Categoria listarCategoriaPeloCodigo(Long id) {

        String jpql = """
                    SELECT c FROM Categoria c WHERE c.id = :codigo
                """;

        return getEntityManager()
                .createQuery(jpql, Categoria.class)
                .setParameter("codigo", id)
                .getResultStream()
                .findAny()
                .orElseThrow();
    }

    @Transactional
    @Override
    public void salvar(CategoriaCommand command) {
        Categoria categoria = new Categoria();
        categoria.setNome(command.nome());

        persist(categoria);
    }

}
