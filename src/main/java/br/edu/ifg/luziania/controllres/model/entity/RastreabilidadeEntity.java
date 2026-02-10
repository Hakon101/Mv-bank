package br.edu.ifg.luziania.controllres.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
@Table(name ="RastreabilidadeEntity")
public class RastreabilidadeEntity {

    //chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "rastreabilidade_seq")
    private Integer id;

    @Getter @Setter
    @Column(nullable = false)
    private String tipo;

    @Getter @Setter
    @Column(nullable = false)
    private double valor;

    @Getter @Setter
    @Column(nullable = false)
    private String destinatario;

    @Getter @Setter
    @Column(nullable = false)
    private String remetente;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime hora;

    public RastreabilidadeEntity() {
    }

    public RastreabilidadeEntity(String tipo, double valor, String destinatario, String remetente) {
        this.tipo = tipo;
        this.valor = valor;
        this.destinatario = destinatario;
        this.remetente = remetente;
    }
}

