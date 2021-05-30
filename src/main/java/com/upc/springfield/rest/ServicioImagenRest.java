package com.upc.springfield.rest;

import com.upc.springfield.entidades.Imagen;
import com.upc.springfield.negocio.ServicioImagenCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Blob;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ServicioImagenRest {

    @Autowired
    private ServicioImagenCore servicioImagenCore;

    @PostMapping("/imagen/{codincidencia}")
    public Boolean registrarImagen(@PathVariable("codincidencia") Long codincidencia, @RequestBody MultipartFile[] file){
        try {
            servicioImagenCore.RegistrarImagen(codincidencia,file);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
