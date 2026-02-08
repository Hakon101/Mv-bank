package br.edu.ifg.luziania.controllres.model.dao;


import br.edu.ifg.luziania.controllres.model.entity.RastreabilidadeEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AdmDAO {

    @Inject
    EntityManager em;

    @Transactional
    public void salvar(RastreabilidadeEntity rastreio) {
        em.persist(rastreio);
    }
}
