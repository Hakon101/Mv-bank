package br.edu.ifg.luziania.controllres.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="EntityPessoa")
    //dar join da classe pessoa com usuario ou admin
@Inheritance(strategy = InheritanceType.JOINED)

public class EntityPessoa {
    //chave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    @SequenceGenerator(name = "pessoa_seq", sequenceName = "entitypessoa_id_seq", allocationSize = 1, initialValue = 2)

    private Integer id;

    @Getter @Setter
    @Column(nullable = false)
    private String nome;

    @Getter @Setter
    @Column(unique = true, nullable = false)
    private String email;

    @Getter @Setter
    @Column(nullable = false)
    private String senha;

protected EntityPessoa(){

}

    public EntityPessoa(Integer id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
