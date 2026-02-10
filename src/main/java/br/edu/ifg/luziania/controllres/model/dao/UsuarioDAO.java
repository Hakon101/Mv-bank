package br.edu.ifg.luziania.controllres.model.dao;

import br.edu.ifg.luziania.controllres.model.entity.EntityPessoa;
import br.edu.ifg.luziania.controllres.model.entity.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

        //só para usuários
@RequestScoped
public class UsuarioDAO {

    @Inject
    EntityManager entityManager;

    public void salvar(Usuario usuario) {
        entityManager.persist(usuario);


    }
    public void atualizar(Usuario usuario) {
        entityManager.merge(usuario);

    }
    public void deletar(Usuario usuario) {
        entityManager.remove(usuario);
    }
    public List<Usuario> listartodos() {
        //lenguage=hql
        String jpql = "from Usuario u";
        return entityManager.createQuery(jpql, Usuario.class).getResultList();
    }

    public EntityPessoa buscarPessoa(String email) {
        String jpql = "from EntityPessoa p where p.email = :email";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("email", email);

        // Retorna a pessoa encontrada ou null
        return (EntityPessoa) query.getSingleResultOrNull();
    }
    public Usuario buscarUsuarioporemail(String email) {
        String jpql = "from Usuario where email = :email";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("email", email);

        // Retorna a pessoa encontrada ou null
        return (Usuario) query.getSingleResultOrNull();
    }
    public Usuario buscarUsuarioPorNumeroDaConta(int conta) {
        String jpql = "from Usuario where id = :conta";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("conta", conta);

        // Retorna a pessoa encontrada ou null
        return (Usuario) query.getSingleResultOrNull();
    }

}