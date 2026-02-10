package br.edu.ifg.luziania.controllres.dto;

import br.edu.ifg.luziania.controllres.model.dao.UsuarioDAO;
import br.edu.ifg.luziania.controllres.model.entity.Usuario;
import jakarta.inject.Inject;
import org.eclipse.microprofile.jwt.JsonWebToken;

public class TransferenciaDTO {

    private double valor;
    private int contaDestino;

    public TransferenciaDTO() {
    }

    public TransferenciaDTO(double valor, int chavedestino) {
        this.valor = valor;
        this.contaDestino = chavedestino;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(int contaDestino) {
        this.contaDestino = contaDestino;
    }

}
