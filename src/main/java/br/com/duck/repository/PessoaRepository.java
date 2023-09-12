package br.com.duck.repository;

import br.com.duck.model.Pessoa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class PessoaRepository {

    @Inject
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Pessoa> findByTerm(String t) {
        String sql = " SELECT p FROM Pessoa p "
                + " LEFT JOIN FETCH p.stack s "
                + " WHERE p.apelido ILIKE '%' || :term || '%' "
                + " OR p.nome ILIKE '%' || :term || '%' "
                + " OR s ILIKE '%' || :term || '%' ";
//                + " OR p.id IN ( SELECT p.id FROM Pessoa p LEFT JOIN p.stack s WHERE s ILIKE '%' || :term || '%' ) ";

        return entityManager.createQuery(sql, Pessoa.class)
                .setParameter("term", t)
                .setHint("org.hibernate.cacheable", Boolean.TRUE)
                .getResultList();
    }

    public Long count() {
        String sql = "SELECT COUNT(*) FROM Pessoa p";

        return (Long) entityManager.createQuery(sql).getSingleResult();
    }
}
