package com.upc.incident.dao;

import com.upc.incident.entidades.Usuario;
import com.upc.incident.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuarioDao {
    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Usuario registrar(Usuario usuario){
        Usuario u;
        u=repositorioUsuario.save(usuario);
        return u;
    }

    public Usuario modificar(Usuario usuario){
        Usuario u;
        u=repositorioUsuario.save(usuario);
        return u;
    }

    public Usuario validarDatosUsuario(String email, String password){
        Usuario usuario;
        usuario=repositorioUsuario.validarUsuario(email,password);
        return  usuario;
    }

    public  Usuario obtenerUsuarioPorEmail(String email){
        Usuario usuario;
        usuario=repositorioUsuario.obtenerUsuarioPorEmail(email);
        return usuario;
    }

    public Usuario obtenerUsuarioPorCodigo(long codigo) {
        Usuario usuario;
        usuario=repositorioUsuario.obtenerUsuarioPorCodigo(codigo);
        return usuario;
    }
}
