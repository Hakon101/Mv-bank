package br.edu.ifg.luziania.controllres.model.entity;

import br.edu.ifg.luziania.controllres.model.bo.InicializaAdministradorBO;
import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/*qundo começar a rodar vai criar um administrador automatiamente*/
@Startup
@Singleton
public class InicializaAdministrador {
    @Inject
    InicializaAdministradorBO service;

    // valores configuráveis no application.properties

    //regata essas informacoes das prorpieades
    @ConfigProperty(name = "admin.initial.nome")
    String nome;

    @ConfigProperty(name = "admin.initial.email")
    String email;

    @ConfigProperty(name = "admin.initial.senha")
    String senha;

    @ConfigProperty(name = "admin.initial.nivel")
    int nivel;

    @PostConstruct
    //@Transactional
    // se nao exixtir cria o admi
    public void init() {
        service.criarAdminSeNaoExistir(nome, email, senha, nivel);
    }
}
