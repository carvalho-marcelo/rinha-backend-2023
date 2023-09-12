package br.com.duck.resource;

import br.com.duck.dto.PessoaDTO;
import br.com.duck.exception.UnprocessableException;
import br.com.duck.model.Pessoa;
import br.com.duck.service.PessoaCache;
import br.com.duck.service.PessoaService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import org.jboss.resteasy.reactive.RestQuery;

import java.net.URI;
import java.util.UUID;

@Path("")
@ApplicationScoped
public class PessoaResource {

    @Inject
    private PessoaService service;

    @Inject
    private PessoaCache cache;

    @POST
    @Path("/pessoas")
    public Response create(@Valid PessoaDTO dto, @Context UriInfo uriInfo) {
        try {
            Pessoa p = new Pessoa(dto);
            p.setId(UUID.randomUUID());

            cache.set(p.getId().toString(), p);
            URI location = uriInfo.getAbsolutePathBuilder().path(p.getId().toString()).build();

            Uni.createFrom().item(service.create(p));

            return Response.created(location).build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnprocessableException(e);
        }
    }

    @GET
    @Path("/pessoas/{id}")
    public Response findById(UUID id) {
        // Caso estiver em cache retorna imediatamente;
        Pessoa pessoa = cache.get(id.toString());
        if (pessoa != null) {
            return Response.ok(pessoa).build();
        }

        // Caso não encontrou no cache recupera no banco de dados;
        Pessoa p = service.findById(id);
        if (p != null) {
            return Response.ok(p).build();
        } else {
            throw new NotFoundException();
        }
    }

    @GET
    @Path("/pessoas")
    public Response findByTerm(@NotNull @RestQuery String t) {
        return Response.ok(service.findByTerm(t)).build();
    }

    @GET
    @Path("/contagem-pessoas")
    public Response countPessoas() {
        return Response.ok(service.count()).build();
    }

}
