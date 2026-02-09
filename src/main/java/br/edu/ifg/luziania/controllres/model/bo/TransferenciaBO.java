package br.edu.ifg.luziania.controllres.model.bo;

import br.edu.ifg.luziania.controllres.dto.TransferenciaDTO;
import br.edu.ifg.luziania.controllres.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.controllres.model.entity.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

//metodo
@Slf4j
@ApplicationScoped
public class TransferenciaBO {
        @Inject

    UsuarioDAO usuarioDAO;
        @Transactional
    public boolean transferencia (TransferenciaDTO transferencia){

            try {
                Usuario usuarioorigem = usuarioDAO.buscarUsuarioporemail(transferencia.getContaorigem());
                Usuario usuariodestino = usuarioDAO.buscarUsuarioporemail(transferencia.getContadestino());
                if (usuarioorigem == null || usuariodestino == null){
                    System.out.println("Essa conta nao existe");
                 return false;
                }
                if (usuarioorigem.getSaldo() < transferencia.getValor()){
                    System.out.println("Saldo insuficiente");
                    return false;
                }
                usuarioorigem.setSaldo(usuarioorigem.getSaldo() - transferencia.getValor());
                usuariodestino.setSaldo(usuariodestino.getSaldo() + transferencia.getValor());
                return true;
            } catch (RuntimeException e) {
                log.error("e: ", e);
                return false;
            }

        }
}
