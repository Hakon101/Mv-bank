package br.edu.ifg.luziania.controllres.controller;

import br.edu.ifg.luziania.controllres.model.entity.RastreabilidadeEntity;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/admin/rastreabilidade")
@Produces(MediaType.APPLICATION_JSON)
public class AdmRastreabilidade {

    @Inject
    EntityManager em;

    @GET
    public List<RastreabilidadeEntity> listarTudo() {
        return em.createQuery(
                "FROM RastreabilidadeEntity ORDER BY dataHora DESC",
                RastreabilidadeEntity.class
        ).getResultList();
    }

    @GET
    @Path("/usuario/{usuario}")
    public List<RastreabilidadeEntity> porUsuario(
            @PathParam("usuario") String usuario) {

        return em.createQuery(
                        "FROM RastreabilidadeEntity WHERE usuario = :u ORDER BY dataHora DESC",
                        RastreabilidadeEntity.class
                ).setParameter("u", usuario)
                .getResultList();
    }
}
