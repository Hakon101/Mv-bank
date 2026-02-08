package br.edu.ifg.luziania.controllres.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "entity_rastreabilidade")
public class RastreabilidadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String usuario;

    @Getter @Setter
    private String controller;

    @Getter @Setter
    private String endpoint;

    @Getter @Setter
    private String metodoHttp;

    @Getter @Setter
    private String ip;

    @Getter @Setter
    private String dataHora;

    public RastreabilidadeEntity() {
    }

    public RastreabilidadeEntity(
            Integer id,
            String usuario,
            String controller,
            String endpoint,
            String metodoHttp,
            String ip,
            String dataHora
    ) {
        this.id = id;
        this.usuario = usuario;
        this.controller = controller;
        this.endpoint = endpoint;
        this.metodoHttp = metodoHttp;
        this.ip = ip;
        this.dataHora = dataHora;
    }
}

