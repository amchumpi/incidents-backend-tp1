package com.upc.incident.rest;

import com.upc.incident.entidades.Categoria;
import com.upc.incident.negocio.ServicioCategoriaCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ServicioCategoriaRest {
    @Autowired
    private ServicioCategoriaCore servicioCategoriaCore;

    @PostMapping("/tipoDocumentoIdentidad")
    public Categoria registrar(@RequestBody Categoria categoria){
        return servicioCategoriaCore.registrarCategoria(categoria);
    }

    @GetMapping("/tipoDocumentoIdentidad/listar")
    public List<Categoria> listarCategorias(){
        return servicioCategoriaCore.listarCategorias();
    }
}
