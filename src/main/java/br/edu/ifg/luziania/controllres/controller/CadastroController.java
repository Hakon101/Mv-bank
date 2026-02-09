package br.edu.ifg.luziania.controllres.controller;

import br.edu.ifg.luziania.controllres.dto.CadastroDTO;
import br.edu.ifg.luziania.controllres.model.bo.CadastroBO;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cadastro")
public class CadastroController {

    @Inject
    CadastroBO cadastroBO; // Injeta a lógica de cadastro

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance cadastro();
    }
    @POST
    @Path("/salvar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(CadastroDTO cadastroDTO) {
        // A lógica de negócio deve validar e salvar no banco
        boolean sucesso = cadastroBO.salvar(cadastroDTO);

        if (sucesso) {
            return Response.status(Response.Status.CREATED)
                    .entity("{\"message\":\"Usuário cadastrado com sucesso!\"}").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"Erro ao cadastrar usuário.\"}").build();
        }
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return CadastroController.Templates.cadastro();
    }
}