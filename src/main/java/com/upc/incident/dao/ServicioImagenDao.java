package com.upc.incident.dao;

import com.upc.incident.entidades.Imagen;
import com.upc.incident.repositorios.RepositorioImagen;
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
