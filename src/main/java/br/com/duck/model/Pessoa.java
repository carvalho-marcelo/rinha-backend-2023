package br.com.duck.model;

import br.com.duck.dto.PessoaDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pessoa")
//@Cacheable
public class Pessoa {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 32, unique = true, nullable = false)
    private String apelido;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate nascimento;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "stack", joinColumns = @JoinColumn(name = "pessoa_id"))
    @Column(length = 32)
//    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    private List<String> stack;

    public Pessoa() {
    }

    public Pessoa(PessoaDTO dto) throws ParseException {
        this.apelido = dto.getApelido();
        this.nome = dto.getNome();
        this.nascimento = LocalDate.parse(dto.getNascimento());
        this.stack = dto.getStack();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public List<String> getStack() {
        return stack;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }
}
