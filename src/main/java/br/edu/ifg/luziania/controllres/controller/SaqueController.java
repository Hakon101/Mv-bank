package br.edu.ifg.luziania.controllres.controller;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/saque")
public class SaqueController {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance saque();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        return SaqueController.Templates.saque();
    }
}


