package br.edu.ifg.luziania.controllres.controller;

import br.edu.ifg.luziania.controllres.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.controllres.model.entity.Usuario;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.Authenticated;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/home")
@Authenticated // Garante que só quem tem o Token/Cookie válido acessa essa classe
    public class HomeController {

    @Inject
    JsonWebToken jwt; // O Quarkus preenche isso automaticamente com os dados do Cookie

    @Inject
    UsuarioDAO usuarioDAO;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance home(Usuario usuario);
    }

    // 1. Rota para carregar a página (GET /home)
    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        // 1. Pega o email do token
        String email = jwt.getClaim("Email");

        // 2. Busca os dados reais no banco
        Usuario usuario = usuarioDAO.buscarUsuarioporemail(email);

        // 3. Renderiza a tela passando o objeto usuário
        return HomeController.Templates.home(usuario);
    }

    // 2. Rota que o botão vai chamar para testar (GET /home/meu-email)
    @GET
    @Path("/meu-email")
    @Produces(MediaType.TEXT_PLAIN)
    public String retornarEmailDoToken() {
        // Acessa o claim "Email" que definimos no AutenticacaoBO
        String email = jwt.getClaim("Email");
        System.out.println("O email no token é: " + email); // Imprime no console do servidor
        return "O seu email é: " + email; // Retorna para o navegador
    }
}