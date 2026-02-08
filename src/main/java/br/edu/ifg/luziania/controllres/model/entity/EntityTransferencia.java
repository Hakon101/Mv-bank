package br.edu.ifg.luziania.controllres.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//tabelas
@Entity
@Table(name ="entity-Transferencia")
public class EntityTransferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private int valor;

    @Getter @Setter
    private int chave;

    public EntityTransferencia(){

    }
    public EntityTransferencia(int valor, int chave,  Integer id ) {
        this.valor = valor;
        this.chave = chave;
        this.id = id;

    }

}
