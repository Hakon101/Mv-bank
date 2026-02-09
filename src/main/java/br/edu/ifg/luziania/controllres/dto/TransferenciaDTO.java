package br.edu.ifg.luziania.controllres.dto;

public class TransferenciaDTO {

    private int valor;
    private String contadestino;
    private String contaorigem;
    public TransferenciaDTO(int valor, String chavedestino, String chaveorigem) {
        this.valor = valor;
        this.contadestino = chavedestino;
        this.contaorigem = chaveorigem;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getContadestino() {
        return contadestino;
    }

    public void setContadestino(String contadestino) {
        this.contadestino = contadestino;
    }

    public String getContaorigem() {
        return contaorigem;
    }

    public void setContaorigem(String contaorigem) {
        this.contaorigem = contaorigem;
    }
}
