package br.edu.ifg.luziania.controllres.filter;

import jakarta.ws.rs.container.ContainerResponseContext;

import org.jboss.resteasy.reactive.server.ServerResponseFilter;

public class JWTResponseFilter {

    @ServerResponseFilter
    public void jwtCookieGenerate(ContainerResponseContext response) {
        String token = response.getHeaderString("token");
        if (token != null) {
            String cookie = "token=" + response.getHeaderString("token")
                + "; path=/; Max-Age=3600; HttpOnly; SameSite=Lax";
            response.getHeaders().add("Set-Cookie", cookie);
        }
    }
}
