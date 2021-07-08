package com.upc.incident.utilitarios;

import com.upc.incident.entidades.Email;
import com.upc.incident.externo.ServicioCorreo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ServicioUtilitario {
    @Autowired
    private ServicioCorreo servicioCorreo;
    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarCorreo(Email correo){
        servicioCorreo.llamarServicioCorreoRest(correo);
    }

    public void sendEmail(Email correo) {
        SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
        simpleMailMessage.setFrom(correo.getDe());
        simpleMailMessage.setTo(correo.getPara().get(0));
        simpleMailMessage.setSubject(correo.getAsunto());
        simpleMailMessage.setText(correo.getMensaje());
        try {
            javaMailSender.send(simpleMailMessage);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
