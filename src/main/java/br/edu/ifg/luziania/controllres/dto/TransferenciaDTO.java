package br.edu.ifg.luziania.controllres.dto;

public class TransferenciaDTO {

    private int valor;
    private int chave;
    public TransferenciaDTO(int valor, int chave) {
        this.valor = valor;
        this.chave = chave;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }
}
