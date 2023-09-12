//package br.com.duck.resource;
//
//import br.com.duck.dto.OldPessoaDTO;
//import br.com.duck.exception.UnprocessableException;
//import br.com.duck.model.OldPessoa;
//import br.com.duck.service.OldPessoaService;
//import io.smallrye.mutiny.Uni;
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.inject.Inject;
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.NotNull;
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.POST;
//import jakarta.ws.rs.Path;
//import jakarta.ws.rs.core.Context;
//import jakarta.ws.rs.core.UriInfo;
//import org.jboss.resteasy.reactive.RestQuery;
//import org.jboss.resteasy.reactive.RestResponse;
//
//import java.net.URI;
//import java.util.List;
//import java.util.UUID;
//
//@Path("old")
//@ApplicationScoped
//public class OldPessoaResource {
//
//    @Inject
//    private OldPessoaService service;
//
//    @POST
//    @Path("/pessoas")
//    public Uni<RestResponse<Object>> create(@Valid OldPessoaDTO dto, @Context UriInfo uriInfo) {
//        Uni<OldPessoa> pessoa = service.create(dto);
//        return pessoa.onItem().transform(p -> {
//            URI location = uriInfo.getAbsolutePathBuilder().path(p.getId().toString()).build();
//            return RestResponse.created(location);
//        }).onFailure().transform(UnprocessableException::new);
//    }
//
//    @GET
//    @Path("/pessoas/{id}")
//    public Uni<OldPessoa> findById(UUID id) {
//        return service.findById(id);
//    }
//
//    @GET
//    @Path("/pessoas")
//    public Uni<List<OldPessoa>> findByTerm(@NotNull @RestQuery String t) {
//        return service.findByTerm(t);
//    }
//
//    @GET
//    @Path("/contagem-pessoas")
//    public Uni<Long> countPessoas() {
//        return OldPessoa.count();
//    }
//
//}
