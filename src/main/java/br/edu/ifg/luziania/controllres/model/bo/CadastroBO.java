package br.edu.ifg.luziania.controllres.model.bo;

import br.edu.ifg.luziania.controllres.dto.CadastroDTO;
import br.edu.ifg.luziania.controllres.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.controllres.model.entity.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped // Necessário para o @Inject funcionar
public class CadastroBO {

    @Inject
    UsuarioDAO usuarioDAO;

    @Transactional
    public boolean salvar(CadastroDTO dto) {
        try {
            // Criar a nova entidade
            Usuario novoUsuario = new Usuario();
            novoUsuario.setNome(dto.getNome());
            novoUsuario.setEmail(dto.getEmail());
            novoUsuario.setSenha(dto.getSenha()); // Em produção, use criptografia
            novoUsuario.setSaldo(100.0);

            usuarioDAO.salvar(novoUsuario);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: "+e);

            return false;
        }
    }
}