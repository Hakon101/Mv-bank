package br.edu.ifg.luziania.controllres.dto;
/// ///
public class PixDTO {

    private String chaveOrigem;
    private String chaveDestino;
    private double valor;

    public PixDTO(String chaveOrigem, String chaveDestino, double valor) {
        this.chaveOrigem = chaveOrigem;
        this.chaveDestino = chaveDestino;
        this.valor = valor;
    }

    public String getChaveDestino() {
        return chaveDestino;
    }

    public void setChaveDestino(String chaveDestino) {
        this.chaveDestino = chaveDestino;
    }

    public String getChaveOrigem() {
        return chaveOrigem;
    }

    public void setChaveOrigem(String chaveOrigem) {
        this.chaveOrigem = chaveOrigem;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
