//package br.com.duck.service;
//
//import br.com.duck.dto.OldPessoaDTO;
//import br.com.duck.exception.UnprocessableException;
//import br.com.duck.model.OldPessoa;
//import br.com.duck.repository.OldPessoaRepository;
//import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
//import io.smallrye.common.annotation.NonBlocking;
//import io.smallrye.mutiny.Uni;
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.inject.Inject;
//
//import java.text.ParseException;
//import java.util.List;
//import java.util.UUID;
//
//@ApplicationScoped
//@WithTransaction
//public class OldPessoaService {
//
//    @Inject
//    private OldPessoaRepository repository;
//
//    @NonBlocking
//    public Uni<OldPessoa> create(OldPessoaDTO dto) {
//        try {
//            OldPessoa pessoa = new OldPessoa(dto);
//            return repository.persist(pessoa);
//        } catch (ParseException e) {
//            throw new UnprocessableException(e);
//        }
//    }
//
//    public Uni<OldPessoa> findById(UUID id) {
//        return repository.findById(id);
//    }
//
//    public Uni<List<OldPessoa>> findByTerm(String t) {
//        return repository.findByTerm(t);
//    }
//}
