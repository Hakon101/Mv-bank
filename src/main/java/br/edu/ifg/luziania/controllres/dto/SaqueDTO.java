package br.edu.ifg.luziania.controllres.dto;

public class SaqueDTO {
    private int valor;
    private int saldo;

    public SaqueDTO(int valor, int saldo) {
        this.valor = valor;
        this.saldo = saldo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
