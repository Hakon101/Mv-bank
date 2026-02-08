package br.edu.ifg.luziania.controllres.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/transferencia")
    public class TransferenciaController {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance transferencia();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return TransferenciaController.Templates.transferencia();
    }
}
