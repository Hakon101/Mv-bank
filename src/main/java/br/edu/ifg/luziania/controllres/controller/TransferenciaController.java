package br.edu.ifg.luziania.controllres.controller;

import br.edu.ifg.luziania.controllres.dto.TransferenciaDTO;
import br.edu.ifg.luziania.controllres.model.bo.TransferenciaBO;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/transferencia")
    public class TransferenciaController {

    @Inject
    TransferenciaBO transferenciaBO;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance transferencia();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return TransferenciaController.Templates.transferencia();
    }

    @POST
    @Path("/transferir")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response transferir(TransferenciaDTO transferenciaDTO) {


        boolean sucesso = transferenciaBO.transferenciaBancaria(transferenciaDTO);

        System.out.println("Sucesso? "+sucesso);
        if (sucesso) {
            return Response.status(Response.Status.CREATED)
                    .entity("{\"message\":\"Transferência realizada com sucesso!\"}").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"Erro ao realizar transferência.\"}").build();
        }
    }
}