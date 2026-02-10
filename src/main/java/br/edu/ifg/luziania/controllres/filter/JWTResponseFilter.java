package br.edu.ifg.luziania.controllres.filter;

import jakarta.ws.rs.container.ContainerResponseContext;

import org.jboss.resteasy.reactive.server.ServerResponseFilter;

public class JWTResponseFilter {


    @ServerResponseFilter //essa anotação faz esse metodo monitorar a saída do servidor
    public void jwtCookieGenerate(ContainerResponseContext response) {
        //verificar se o cabeçalho se chama token para gear  o cookie
        String token = response.getHeaderString("token");
        if (token != null) {
            String cookie = "token=" + response.getHeaderString("token")
                + "; path=/; Max-Age=3600; HttpOnly; SameSite=Lax"; //somete   http e não https, o quarkus impede por motivos de segurança
            response.getHeaders().add("Set-Cookie", cookie); //adciona um setcooki na resposta para o navegador add o cookie automaticamente. f12
        }
    }
}
