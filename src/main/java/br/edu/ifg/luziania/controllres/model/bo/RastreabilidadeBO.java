package br.edu.ifg.luziania.controllres.model.bo;
import br.edu.ifg.luziania.controllres.model.dao.AdmDAO;
import br.edu.ifg.luziania.controllres.model.entity.RastreabilidadeEntity;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
/// ///
@Provider
@Priority(Priorities.USER)
public class RastreabilidadeBO implements ContainerRequestFilter {

    @Inject
    AdmDAO dao;

    @Override
    public void filter(ContainerRequestContext request) {

    }
}

