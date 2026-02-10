package br.edu.ifg.luziania.controllres.model.dao;

import br.edu.ifg.luziania.controllres.model.entity.RastreabilidadeEntity;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class RastreabilidadeDAO {
    @Inject
    EntityManager entityManager;
    public void salvar(RastreabilidadeEntity registro){
        entityManager.persist(registro);
    }
    public List<RastreabilidadeEntity> listarAtividades(){
        return entityManager.createQuery("FROM RastreabilidadeEntity r ORDER BY r.hora DESC", RastreabilidadeEntity.class)
                .getResultList();
    }
}
