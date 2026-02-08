package br.edu.ifg.luziania.controllres.model.bo;

import br.edu.ifg.luziania.controllres.dto.LoginDTO;
import br.edu.ifg.luziania.controllres.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.controllres.model.entity.Administrador;
import br.edu.ifg.luziania.controllres.model.entity.EntityPessoa;
import br.edu.ifg.luziania.controllres.model.entity.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

//metodo
@RequestScoped
public class LoguinBO {

    @Inject
    UsuarioDAO usuarioDAO;

    public String login(LoginDTO credenciais) {
        EntityPessoa pessoa = usuarioDAO.buscarPessoa(credenciais);

        if (pessoa == null) {
            return null; // Credenciais inválidas
        }

        // Verifica se a instância é de um Administrador
        if (pessoa instanceof Administrador) {
            return "admin";
        }

        // Caso contrário, é um Usuário comum
        return "usuario";
    }
}
