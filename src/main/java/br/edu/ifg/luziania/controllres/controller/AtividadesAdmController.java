package br.edu.ifg.luziania.controllres.controller;

import br.edu.ifg.luziania.controllres.model.dao.RastreabilidadeDAO;
import br.edu.ifg.luziania.controllres.model.entity.RastreabilidadeEntity;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/atividadesAdm")
public class AtividadesAdmController {

    @Inject
    RastreabilidadeDAO rastreabilidadeDAO;

    @CheckedTemplate
    public static class Templates {
        // Define que o template vai receber uma LISTA de entidades
        public static native TemplateInstance atividadesAdm(List<RastreabilidadeEntity> atividades);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        // Busca no banco e passa para o HTML
        return Templates.atividadesAdm(rastreabilidadeDAO.listarAtividades());
    }
}







