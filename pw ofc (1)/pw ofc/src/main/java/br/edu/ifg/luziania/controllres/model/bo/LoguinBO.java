package br.edu.ifg.luziania.controllres.model.bo;

import br.edu.ifg.luziania.controllres.dto.LoginDTO;
import br.edu.ifg.luziania.controllres.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.controllres.model.entity.Usuario;
import jakarta.inject.Inject;

//metodo
public class LoguinBO {

    @Inject
    UsuarioDAO usuarioDAO;

    public boolean login(LoginDTO credenciais) {

        Usuario usuario = usuarioDAO.buscarUsuario(credenciais);

        if (usuario == null) {
            return false;
        }

        // ⚠️ simples (não usar em produção sem hash)
        return usuario.getSenha().equals(credenciais.getSenha());
    }
}
