package com.upc.springfield.dao;

import com.upc.springfield.entidades.Imagen;
import com.upc.springfield.repositorios.RepositorioImagen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioImagenDao {
    @Autowired
    private RepositorioImagen repositorioImagen;

    public Imagen RegistrarImagen(Imagen imagen){
        return repositorioImagen.save(imagen);
    }



}
