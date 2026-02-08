package br.edu.ifg.luziania.controllres.model.entity;

import io.quarkus.arc.All;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//tabelas BD
@Entity
@Table(name ="usuario")



    public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false)
        private String nome;

        @Column(unique = true, nullable = false)
        private String email;

        @Column(nullable = false)
        private String senha;

        @Column(nullable = false)
        private boolean eAdmin;

        // getters e setters
        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public boolean getPermissao() {
            return eAdmin;
        }

        public void setPermissao(boolean eAdmin) {
            this.eAdmin = eAdmin;
        }


    public Usuario() {


    }

    public Usuario(Integer id, String usuario, String senha, boolean eAdmin) {
        this.id = id;
        this.nome = usuario;
        this.senha = senha;
        this.eAdmin = eAdmin;
    }
}
