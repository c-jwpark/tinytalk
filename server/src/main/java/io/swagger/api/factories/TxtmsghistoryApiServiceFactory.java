package io.swagger.api.factories;

import io.swagger.api.TxtmsghistoryApiService;
import io.swagger.api.impl.TxtmsghistoryApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-05-27T15:54:36.606Z")
public class TxtmsghistoryApiServiceFactory {
    private final static TxtmsghistoryApiService service = new TxtmsghistoryApiServiceImpl();

    public static TxtmsghistoryApiService getTxtmsghistoryApi() {
        return service;
    }
}