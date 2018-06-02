package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.TxtmsgApiService;
import io.swagger.api.factories.TxtmsgApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.TxtMsgRequest;
import io.swagger.model.TxtMsgResult;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/txtmsg")


@io.swagger.annotations.Api(description = "the txtmsg API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-06-02T15:11:52.437Z")
public class TxtmsgApi  {
   private final TxtmsgApiService delegate;

   public TxtmsgApi(@Context ServletConfig servletContext) {
      TxtmsgApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("TxtmsgApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (TxtmsgApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = TxtmsgApiServiceFactory.getTxtmsgApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Send text message", notes = "", response = TxtMsgResult.class, tags={ "txtmsg", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = TxtMsgResult.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Void.class) })
    public Response txtMsg(@ApiParam(value = "Text message" ,required=true) TxtMsgRequest body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.txtMsg(body,securityContext);
    }
}
