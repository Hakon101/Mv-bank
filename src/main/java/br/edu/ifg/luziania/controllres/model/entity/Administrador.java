package br.edu.ifg.luziania.controllres.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


//tabelas BD
@Entity
@Table(name ="administrador")

    public class Administrador extends EntityPessoa{

        @Getter @Setter
        private int nivel;

        public Administrador( String nome, String email, String senha,int nivel){
            super(nome,email,senha,"admin");
        this.nivel = nivel;
        }



        protected Administrador() {
        }

    }
