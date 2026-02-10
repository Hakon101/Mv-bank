package br.edu.ifg.luziania.controllres.model.bo;

import br.edu.ifg.luziania.controllres.dto.PixDTO;
import br.edu.ifg.luziania.controllres.dto.TransferenciaDTO;
import br.edu.ifg.luziania.controllres.model.dao.RastreabilidadeDAO;
import br.edu.ifg.luziania.controllres.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.controllres.model.entity.RastreabilidadeEntity;
import br.edu.ifg.luziania.controllres.model.entity.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.JsonWebToken;

//metodo
@Slf4j
@ApplicationScoped
public class TransferenciaBO {
    @Inject
    JsonWebToken jwt;
        @Inject
    UsuarioDAO usuarioDAO;
        @Inject
    RastreabilidadeDAO rastreabilidadeDAO;
        @Transactional
    public boolean transferenciaBancaria(TransferenciaDTO transferencia){

            try {

                String email = jwt.getClaim("Email");

                Usuario usuarioorigem = usuarioDAO.buscarUsuarioporemail(email);
                Usuario usuariodestino = usuarioDAO.buscarUsuarioPorNumeroDaConta(transferencia.getContaDestino());
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

                RastreabilidadeEntity registro = new RastreabilidadeEntity();
                registro.setTipo("transferencia");
                registro.setValor(transferencia.getValor());
                registro.setRemetente(usuarioorigem.getEmail());
                registro.setDestinatario(usuariodestino.getEmail());

                rastreabilidadeDAO.salvar(registro);


                return true;
            } catch (RuntimeException e) {
                log.error("e: ", e);
                return false;
            }

        }



    @Transactional
    public boolean transferenciaPix (PixDTO pix){

        try {
            Usuario usuarioorigem = usuarioDAO.buscarUsuarioporemail(pix.getChaveOrigem());
            Usuario usuariodestino = usuarioDAO.buscarUsuarioporemail(pix.getChaveDestino());
            if (usuarioorigem == null || usuariodestino == null){
                System.out.println("Essa conta nao existe");
                return false;
            }
            if (usuarioorigem.getSaldo() < pix.getValor()){
                System.out.println("Saldo insuficiente");
                return false;
            }
            usuarioorigem.setSaldo(usuarioorigem.getSaldo() - pix.getValor());
            usuariodestino.setSaldo(usuariodestino.getSaldo() + pix.getValor());
            return true;
        } catch (RuntimeException e) {
            log.error("e: ", e);
            return false;
        }

    }
}
