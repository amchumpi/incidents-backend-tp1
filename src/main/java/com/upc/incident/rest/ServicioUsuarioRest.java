package com.upc.incident.rest;

import com.upc.incident.entidades.Credenciales;
import com.upc.incident.entidades.Usuario;
import com.upc.incident.negocio.ServicioUsuarioCore;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/usuario/subircategoria/{cod_usuario}")
    public Usuario SubirCategoria(@PathVariable("cod_usuario") Long cod_usuario){
        Usuario usuario;
        usuario=servicioUsuarioCore.upgradeCategoria(cod_usuario);
        return usuario;
    }
}
