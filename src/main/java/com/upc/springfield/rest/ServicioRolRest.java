package com.upc.springfield.rest;

import com.upc.springfield.entidades.Rol;
import com.upc.springfield.negocio.ServicioRolCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ServicioRolRest {
    @Autowired
    private ServicioRolCore servicioRolCore;

    @PostMapping("/rol")
    public Rol registrar(Rol rol){
        Rol r;
        r=servicioRolCore.registrarRol(rol);
        return r;
    }

    @GetMapping("/rol/listar")
    public List<Rol> listarRoles(){
        return servicioRolCore.listarRoles();
    }
}
