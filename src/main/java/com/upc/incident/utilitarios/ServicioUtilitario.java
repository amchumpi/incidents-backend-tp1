package com.upc.incident.utilitarios;

import com.upc.incident.entidades.Email;
import com.upc.incident.externo.ServicioCorreo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUtilitario {
    @Autowired
    private ServicioCorreo servicioCorreo;

    public void enviarCorreo(Email correo){
        servicioCorreo.llamarServicioCorreoRest(correo);
    }
}
