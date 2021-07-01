package com.upc.incident.dao;

import com.upc.incident.entidades.Categoria;
import com.upc.incident.repositorios.RepositorioCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCategoriaDao {
    @Autowired
    private RepositorioCategoria repositorioCategoria;

    public Categoria registrar(Categoria categoria){
        return repositorioCategoria.save(categoria);
    }

    public List<Categoria> listarCategoria(){
        List<Categoria> lista;
        lista=(List<Categoria>)repositorioCategoria.findAll();
        return lista;
    }
}
