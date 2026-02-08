package br.edu.ifg.luziania.controllres.model.dao;

import br.edu.ifg.luziania.controllres.dto.LoginDTO;
import br.edu.ifg.luziania.controllres.model.entity.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.annotations.processing.HQL;

@RequestScoped
public class UsuarioDAO {

    @Inject
    EntityManager entityManager;

    public Usuario salvar(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;

    }
    public Usuario atualizar(Usuario usuario) {
        return entityManager.merge(usuario);

    }
    public void deletar(Usuario usuario) {
        entityManager.remove(usuario);
    }
    public List<Usuario> listartodos() {
        //lenguage=hql
        String jpql = "from Usuario u";
        return entityManager.createQuery(jpql, Usuario.class).getResultList();
    }

    public Usuario buscarUsuario(LoginDTO credenciais) {
        //language=hql
        String jpql = "from Usuario u where u.email = :email and u.senha = :senha";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("email", credenciais.getUsuario());
        query.setParameter("senha", credenciais.getSenha());
        Usuario usuario = (Usuario) query.getSingleResultOrNull();
        return usuario;
    }

}