package br.edu.ifg.luziania.controllres.model.bo;

import br.edu.ifg.luziania.controllres.controller.JWTController;
import br.edu.ifg.luziania.controllres.dto.CadastroDTO;
import br.edu.ifg.luziania.controllres.dto.LoginDTO;
import br.edu.ifg.luziania.controllres.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.controllres.model.entity.EntityPessoa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

//metodo
@RequestScoped
public class AutenticacaoBO {



    @Inject
    JWTController jwt;

    @Inject
    UsuarioDAO usuarioDAO;

    public Response Autenticar(LoginDTO credenciais) {
        EntityPessoa pessoa = usuarioDAO.buscarPessoa(credenciais);

        if (pessoa == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\": \"Usuário ou senha inválidos\"}")
                    .type("application/json")
                    .build();

        }

        CadastroDTO cadastroDTO = new CadastroDTO(pessoa.getNome(), pessoa.getEmail(), credenciais.getSenha(), pessoa.getTipo());

        return jwt.generateJWT(cadastroDTO);
    }
}