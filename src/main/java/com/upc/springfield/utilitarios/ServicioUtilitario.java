package com.upc.springfield.utilitarios;

import com.upc.springfield.entidades.Email;
import com.upc.springfield.externo.ServicioCorreo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class ServicioUtilitario {
    @Autowired
    private ServicioCorreo servicioCorreo;

    public void enviarCorreo(Email correo){
        servicioCorreo.llamarServicioCorreoRest(correo);
    }
}
