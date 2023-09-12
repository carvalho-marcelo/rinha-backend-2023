package br.com.duck.service;

import br.com.duck.model.Pessoa;
import br.com.duck.repository.PessoaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Transactional
public class PessoaService {

    @Inject
    private PessoaRepository repository;

    public Pessoa create(Pessoa pessoa) {
        repository.getEntityManager().persist(pessoa);
        return pessoa;
    }

    public Pessoa findById(UUID id) {
        return repository.getEntityManager().find(Pessoa.class, id);
    }

    public List<Pessoa> findByTerm(String t) {
        return repository.findByTerm(t);
    }

    public Long count() {
        return repository.count();
    }
}
