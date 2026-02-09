package br.edu.ifg.luziania.controllres.controller;

import br.edu.ifg.luziania.controllres.dto.CadastroDTO;
import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;

@Path("jwt")
public class JWTController {

    @GET
    @Path("generate")
    public Response generateJWT(CadastroDTO cadastroDTO){
        String token = Jwt
                .issuer("http://localhost/issuer")
                .upn(cadastroDTO.getEmail())
                .groups(cadastroDTO.getTipo())  //Perfil (Role)
                .claim("Nome", cadastroDTO.getNome())
                .claim("Email", cadastroDTO.getEmail())



                .sign();
        String jsonBody = "{\"message\":\"Token jwt criado e guardado no cookie\", \"tipo\":\"" + cadastroDTO.getTipo() + "\"}";
        return Response
                .ok(jsonBody)
                .header("token", token)
                .build();
    }


    @GET
    @Path("sem-autenticacao")
    @PermitAll
    public Response metodoSemSeguranca(){
        return Response.ok("Método sem segurança").build();
    }

    @GET
    @Path("protegido-admin")
    @RolesAllowed({"Admin"})
    public Response metodoProtegidoAdmin(){
        return Response.ok("Método para Admin").build();
    }

    @GET
    @Path("protegido-paciente")
    @RolesAllowed({"Paciente"})
    public Response metodoProtegidoPaciente(){
        return Response.ok("Método para Paciente").build();
    }


}
