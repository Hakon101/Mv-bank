package br.edu.ifg.luziania.controllres.model.bo;
import br.edu.ifg.luziania.controllres.model.dao.AdmDAO;
import br.edu.ifg.luziania.controllres.model.entity.RastreabilidadeEntity;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.USER)
public class RastreabilidadeBO implements ContainerRequestFilter {

    @Inject
    AdmDAO dao;

    @Override
    public void filter(ContainerRequestContext request) {

        RastreabilidadeEntity r = new RastreabilidadeEntity();

        r.setEndpoint(request.getUriInfo().getPath());
        r.setMetodoHttp(request.getMethod());
        r.setController(extrairController(request.getUriInfo().getPath()));

        r.setIp(
                request.getHeaderString("X-Forwarded-For") != null
                        ? request.getHeaderString("X-Forwarded-For")
                        : request.getHeaderString("Host")
        );

        // usuário pode vir do login
        String usuario = request.getHeaderString("X-USER");
        r.setUsuario(usuario != null ? usuario : "anonimo");

        dao.salvar(r);
    }

    private String extrairController(String path) {
        if (path == null || path.isEmpty()) return "desconhecido";
        return path.split("/admin/rastreabilidade")[0];
    }
}

