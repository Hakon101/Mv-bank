package br.edu.ifg.luziania.controllres.dto;

public class PixDTO {

    private int chave;
    private int valor;

    public PixDTO(int chave, int valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
