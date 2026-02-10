package br.edu.ifg.luziania.controllres.model.bo;

import br.edu.ifg.luziania.controllres.controller.JWTController;
import br.edu.ifg.luziania.controllres.dto.CadastroDTO;
import br.edu.ifg.luziania.controllres.dto.LoginDTO;
import br.edu.ifg.luziania.controllres.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.controllres.model.entity.EntityPessoa;
import io.quarkus.elytron.security.common.BcryptUtil;
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
        EntityPessoa pessoa = usuarioDAO.buscarPessoa(credenciais.getUsuario());
        if (pessoa == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\": \"Usuário ou senha inválidos\"}")

                    .type("application/json")
                    .build(); // gmail inválido

        }
        System.out.println(BcryptUtil.matches(credenciais.getSenha(), pessoa.getSenha()));
            //matches fará a comparação do hesh das senhas
        if (!BcryptUtil.matches(credenciais.getSenha(), pessoa.getSenha())) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("{\"error\": \"Usuário ou senha inválidos\"}")
                    .type("application/json")
                    .build(); // Senha inválida
        }

        CadastroDTO cadastroDTO = new CadastroDTO(pessoa.getNome(), pessoa.getEmail(), credenciais.getSenha(), pessoa.getTipo());

        return jwt.generateJWT(cadastroDTO); //retorna para o logincontroller
    }
}