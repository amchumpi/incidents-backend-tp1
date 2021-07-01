package com.upc.incident.negocio;

import com.upc.incident.dao.ServicioCategoriaDao;
import com.upc.incident.entidades.Categoria;
import com.upc.incident.entidades.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioCategoriaCore {
    @Autowired
    private ServicioCategoriaDao servicioCategoriaDao;

    public Categoria registrarCategoria(Categoria categoria){
        Categoria r;
        try{
            r=servicioCategoriaDao.registrar(categoria);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al registrar Categoria.\nDetalle: " + e.getMessage());
        }
        return r;
    }

    public List<Categoria> listarCategorias(){
        List<Categoria> lista= new ArrayList<>();
        try{
            lista=servicioCategoriaDao.listarCategoria();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al listar Categorias.\nDetalle: " + e.getMessage());
        }
        return lista;
    }
}
