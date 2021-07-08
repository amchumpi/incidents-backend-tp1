package com.upc.incident.utilitarios;


import com.upc.incident.entidades.Email;
import com.upc.incident.externo.ServicioCorreo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.CharEncoding;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class ServicioUtilitario {
    Logger logger = LoggerFactory.getLogger(ServicioUtilitario.class);
    @Autowired
    private ServicioCorreo servicioCorreo;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment env;

    public void enviarCorreo(Email correo){
        servicioCorreo.llamarServicioCorreoRest(correo);
    }

    public Boolean sendEmail(Email correo) {
        Boolean status = false;
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true, CharEncoding.UTF_8);

            //helper.setFrom(env.getProperty("spring.mail.username"));
            helper.setFrom(correo.getDe());
            helper.setTo(correo.getPara());
            helper.setSubject(correo.getAsunto() != null ? correo.getAsunto() : "");
            helper.setText(correo.getMensaje() != null ? correo.getMensaje() : "", true);
            javaMailSender.send(mail);
            logger.info("Correo enviado exitosamente!");
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Error al enviar correo: " + e.getMessage());
        }
        return status;
    }

    //public Boolean sendEmail(String[] sendTo, String subject, String body) {
    //    return sendEmail(sendTo, subject, body, null);
    //}
}
