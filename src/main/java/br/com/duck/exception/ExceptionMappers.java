package br.com.duck.exception;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class ExceptionMappers {

    @ServerExceptionMapper
    public RestResponse<String> mapException(UnprocessableException e) {
        return RestResponse.status(422, "Requisição inválida: " + e.getMessage());
    }
}
