package br.edu.ifg.luziania.controllres.model.bo;

import br.edu.ifg.luziania.controllres.dto.LoginDTO;
import br.edu.ifg.luziania.controllres.dto.UsuarioDTO;
import br.edu.ifg.luziania.controllres.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.controllres.model.entity.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.core.Response;
import jdk.jfr.Registered;


//repositorio BD
@RequestScoped
public class AutenticacaoBO {

    @Inject
    UsuarioDAO usuarioDAO;

    public Response autenticar(LoginDTO credenciais) {
        Usuario usuario = usuarioDAO.buscarUsuario(credenciais);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        UsuarioDTO dto = new UsuarioDTO(usuario.getId(), usuario.getNome(),usuario.getEmail(), false);
        return Response.ok(dto).build();
    }
}
