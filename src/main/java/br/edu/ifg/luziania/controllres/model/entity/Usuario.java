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



    public class Usuario extends EntityPessoa{

        @Getter @Setter
        private double saldo;


        public Usuario() {
        }

        public Usuario(Integer id, String nome, String email, String senha,double saldo){
            super(id, nome, email, senha);
            this.saldo = saldo;
        }


    }
