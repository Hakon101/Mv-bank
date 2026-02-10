package br.edu.ifg.luziania.controllres.model.entity;


import io.quarkus.elytron.security.common.BcryptUtil;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pessoa_seq")
    //@SequenceGenerator(name = "pessoa_seq", sequenceName = "entitypessoa_id_seq", allocationSize = 1, initialValue = 2)
    @Getter @Setter

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

    @Getter @Setter
    @Column(nullable = false)
    private String tipo;

protected EntityPessoa(){

}

    public EntityPessoa(String nome, String email, String senha, String tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = BcryptUtil.bcryptHash(senha);
        this.tipo = tipo;
    }
}
