package com.upc.incident.dao;

import com.upc.incident.entidades.Rol;
import com.upc.incident.repositorios.RepositorioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioRolDao {
    @Autowired
    private RepositorioRol repositorioRol;

    public Rol registrar(Rol rol){
        Rol r;
        r=repositorioRol.save(rol);
        return r;
    }

    public List<Rol> listarRoles(){
        List<Rol> lista= new ArrayList<>();
        lista=(List<Rol>)repositorioRol.findAll();
        return lista;
    }
}
