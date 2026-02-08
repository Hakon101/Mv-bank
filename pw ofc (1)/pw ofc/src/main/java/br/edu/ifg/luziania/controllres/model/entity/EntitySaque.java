package br.edu.ifg.luziania.controllres.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//tabelas
@Table(name ="entitySaque")
@Entity
public class EntitySaque {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private int valor;

    @Getter @Setter
    private int saldo;

    public EntitySaque() {

    }
    public EntitySaque(int valor, int saldo, Integer id) {
        this.valor = valor;
        this.saldo = saldo;
        this.id = id;
    }

}
