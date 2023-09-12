//package br.com.duck.repository;
//
//import br.com.duck.model.OldPessoa;
//import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
//import io.smallrye.mutiny.Uni;
//import io.vertx.mutiny.sqlclient.Row;
//import jakarta.enterprise.context.ApplicationScoped;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@ApplicationScoped
//public class OldPessoaRepository implements PanacheRepositoryBase<OldPessoa, UUID> {
//
//    public Uni<List<OldPessoa>> findByTerm(String t) {
//        String sql = " SELECT p FROM Pessoa p "
//                + " LEFT JOIN FETCH p.stack s "
//                + " WHERE UPPER(p.apelido) LIKE '%' || ?1 || '%' "
//                + " OR UPPER(p.nome) LIKE '%' || ?1 || '%' "
//                + " OR p.id IN ( SELECT p.id FROM Pessoa p LEFT JOIN p.stack s WHERE UPPER(s) LIKE '%' || ?1 || '%' ) ";
////                + " OR UPPER(s) LIKE '%' || ?1 || '%' ";
//
//        return find(sql.toString(), t.toUpperCase()).range(0, 50).list();
//    }
//
//    private static OldPessoa from(Row row) {
//        OldPessoa p = new OldPessoa();
//        p.setId(row.getUUID("id"));
//        p.setApelido(row.getString("apelido"));
//        p.setNome(row.getString("nome"));
//        p.setNascimento(row.getLocalDate("nascimento"));
//        p.setStack(Arrays.stream(row.getArrayOfStrings("stack")).collect(Collectors.toList()));
//        return p;
//    }
//}
