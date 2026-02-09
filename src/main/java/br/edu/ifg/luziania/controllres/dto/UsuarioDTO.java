package br.edu.ifg.luziania.controllres.dto;

import lombok.Getter;
import lombok.Setter;

public class UsuarioDTO {
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private double saldo;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String nome, String email, double saldo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.saldo = saldo;
    }
}
