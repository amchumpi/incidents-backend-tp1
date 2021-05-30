package com.upc.springfield.rest;

import com.upc.springfield.entidades.Credenciales;
import com.upc.springfield.entidades.Usuario;
import com.upc.springfield.negocio.ServicioUsuarioCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ServicioUsuarioRest {
    @Autowired
    private ServicioUsuarioCore servicioUsuarioCore;

    @PostMapping("/usuario")
    public Usuario registrar(@RequestBody Usuario usuario){
        return servicioUsuarioCore.registrarUsuario(usuario);
    }

    @PutMapping("/usuario/modificar")
    public Usuario modificar(@RequestBody Usuario usuario){
        return servicioUsuarioCore.modificarUsuario(usuario);
    }

    @PostMapping("/usuario/validar")
    public Usuario validarUsuario(@RequestBody Credenciales credenciales){
        Usuario usuario;
        usuario=servicioUsuarioCore.validarUsuario(credenciales);
        return usuario;
    }

    @GetMapping("/usuario/obtenerusuario/{email}")
    public Usuario obtenerUsuario(@PathVariable("email") String email){
        Usuario usuario;
        usuario=servicioUsuarioCore.obtenerUsuarioPorEmail(email);
        return usuario;
    }
}
