package br.edu.ifg.luziania.controllres.model.bo;

import br.edu.ifg.luziania.controllres.model.entity.Administrador;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RequestScoped
public class InicializaAdministradorBO {
    @Inject
    EntityManager em;
    //
    @Transactional
    public void criarAdminSeNaoExistir(String nome, String email, String senha, int nivel) {
        //faz consulta do banco para verificar todas as quantidades de linhas na tabela
        Long count = em.createQuery(
                        "SELECT COUNT(a) FROM Administrador a", Long.class)
                .getSingleResult();
            //se caunt for 0 nao existe admiistrador
        if (count == 0) {
            Administrador admin = new Administrador(nome, email, senha, nivel);
            em.persist(admin);
            System.out.println("Administrador inicial criado com email: " + email);
            //logo aqui inicia a criação de um novo admn se nao tiver
        }
    }
}