package br.edu.ifg.luziania.controllres.controller;

import br.edu.ifg.luziania.controllres.dto.LoginDTO;
import br.edu.ifg.luziania.controllres.model.bo.LoguinBO; // Verifique se o nome está correto (Loguin ou Login)
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class LoginController {

    @Inject
    LoguinBO loginBO; // Injeta a lógica de negócio

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance login();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return Templates.login();
    }

    @POST
    @Path("/logar") // Esta é a sub-rota para a comunicação
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logar(LoginDTO loginDTO) {
        String tipo = loginBO.login(loginDTO);

        System.out.println("Tipo: "+tipo);

        if (tipo != null) {
            // Retorna o tipo para o frontend saber para onde redirecionar
            return Response.ok("{\"message\":\"Sucesso\", \"tipo\":\"" + tipo + "\"}").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("{\"error\":\"Incorreto\"}").build();
        }
    }
}