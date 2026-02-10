package br.edu.ifg.luziania.controllres.controller;

import br.edu.ifg.luziania.controllres.dto.LoginDTO;
import br.edu.ifg.luziania.controllres.model.bo.AutenticacaoBO; // Verifique se o nome está correto (Loguin ou Login)
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/")
public class LoginController {

    @Inject
    AutenticacaoBO autenticacaoBO; // Injeta a lógica de negócio
    JsonWebToken jwt;

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
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response logar(LoginDTO loginDTO) {
        return autenticacaoBO.Autenticar(loginDTO);// e do login controller para web
    }
}