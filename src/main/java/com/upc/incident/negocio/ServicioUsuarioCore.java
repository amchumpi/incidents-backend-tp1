package com.upc.incident.negocio;

import com.upc.incident.dao.ServicioUsuarioDao;
import com.upc.incident.entidades.Credenciales;
import com.upc.incident.entidades.Email;
import com.upc.incident.entidades.Usuario;
import com.upc.incident.utilitarios.ServicioUtilitario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioUsuarioCore {
    @Autowired
    private ServicioUsuarioDao servicioUsuarioDao;
    @Autowired
    private ServicioUtilitario servicioUtilitario;

    public Usuario registrarUsuario(Usuario usuario){
        Usuario u;
        try {
            u = servicioUsuarioDao.registrar(usuario);
//            try {
//                this.enviarMensajeBienvenida(u);
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al registrar Usuario.\nDetalle: " + e.getMessage());
        }
        return u;
    }

    public Usuario modificarUsuario(Usuario usuario){
        Usuario u;
        try{
            if(usuario.getTipoDocIdentidad()!=null && usuario.getNroDocIdentidad()!=null)
                if(!usuario.getTipoDocIdentidad().getCodigo().equals("") && !usuario.getNroDocIdentidad().equals(""))
                    u=servicioUsuarioDao.modificar(usuario);
                else
                    throw new Exception("El usuario tiene código 0.)");
            else
                throw new Exception("El usuario no tiene código(nulo).");
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al modificar Usuario.\nDetalle: " + e.getMessage());
        }
        return u;
    }

    public Usuario validarUsuario(Credenciales credenciales){
        Usuario usuario;
        try {
            if(credenciales.getEmail().equals("")){
                throw new Exception("No se envió el email.");
            }
            if(credenciales.getPassword().equals("")){
                throw new Exception("No se envió el password.");
            }
            usuario = servicioUsuarioDao.validarDatosUsuario(credenciales.getEmail(), credenciales.getPassword());
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al validar datos de Usuario.\nDetalle: " + e.getMessage());
        }
        return usuario;
    }

    public Usuario obtenerUsuarioPorEmail(String email){
        Usuario usuario;
        try {

            usuario = servicioUsuarioDao.obtenerUsuarioPorEmail(email);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al validar datos de Usuario.\nDetalle: " + e.getMessage());
        }
        return usuario;
    }


    private void enviarMensajeBienvenida(Usuario usuario){
        Email email= new Email();
        List<String> listaPara= new ArrayList<>();
        List<String> listaCc= new ArrayList<>();
        List<String> listaBcc= new ArrayList<>();
        String mensaje;
        listaPara.add(usuario.getEmail());

        mensaje="";
        mensaje +="Bienvenido(a) " + usuario.getNombre().toUpperCase().trim() + " " + usuario.getApellidoPaterno() + " " + usuario.getApellidoMaterno() +".\n";
        mensaje +="\n";
        mensaje +="Atte.\nEl equipo de Springfield";

        email.setAsunto("Bienvenido a la aplicación 'Reporteamos Todos!'");
        email.setPara(listaPara);
        email.setCc(listaCc);
        email.setBcc(listaBcc);
        email.setConFormatoHtml(true);
        email.setDe("no-reply@springfield.com");
        email.setMensaje(this.normalizarMensajeHtml( mensaje));
        servicioUtilitario.enviarCorreo(email);

    }

    private String normalizarMensajeHtml(String mensaje){
        String html="";
        html +="<html><title></title>";
        html +="<body>";
        html += mensaje.replace("\n","<br>");
        html +="</body>";
        html +="</html>";
        return html;
    }
}
