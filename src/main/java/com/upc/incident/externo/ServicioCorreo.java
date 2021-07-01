package com.upc.incident.externo;

import com.upc.incident.entidades.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServicioCorreo {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${rest.url.servcorreo.enviarcorreo}")
    private String uri;

    public void llamarServicioCorreoRest(Email correo){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String listaPara="";
        String listaCc="";
        String listaBcc="";

        for(String para:correo.getPara()) {
            if(listaPara.trim()!="") listaPara +=",";
            listaPara += "\"" + para + "\"";
        }

        for(String cc:correo.getCc()) {
            if(listaCc.trim()!="") listaCc +=",";
            listaCc += "\"" + cc + "\"";
        }

        for(String bcc:correo.getBcc()) {
            if(listaBcc.trim()!="") listaBcc +=",";
            listaBcc += "\"" + bcc + "\"";
        }

        String json="{\"correo\":{";
        json +="\"De\":\"" + correo.getDe() + "\",";
        json +="\"Para\":[";
        json += listaPara;
        json +="],";
        json +="\"Cc\":[";
        json += listaCc;
        json +="],";
        json +="\"Bcc\":[";
        json += listaBcc;
        json +="],";
        json +="\"Asunto\":\" " + correo.getAsunto() + "\",";
        json +="\"Mensaje\":\" " + correo.getMensaje() + "\",";
        if(correo.isConFormatoHtml()) json +="\"ConFormatoHtml\":true";
        else json +="\"ConFormatoHtml\":false";
        json +="}";
        json +="}";

        HttpEntity<String> entity = new HttpEntity<String>(json, headers);

        restTemplate.postForObject(uri,entity,String.class);
    }
}
