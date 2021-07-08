package com.upc.incident.negocio;

import com.upc.incident.dao.ServicioUsuarioDao;
import com.upc.incident.entidades.Categoria;
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
        Categoria categoria;
        try {
            categoria=new Categoria();
            categoria.setCodigo("01");  //freemium
            usuario.setCategoria(categoria);

            u=servicioUsuarioDao.obtenerUsuarioPorEmail(usuario.getEmail());

            if(u!=null) {
                if(u.getCodigo()>0){
                    throw new Exception("Ya existe una cuenta para el correo " + usuario.getEmail() + ".");
                }
            }

            u = servicioUsuarioDao.registrar(usuario);
            try {
                this.enviarMensajeBienvenida(u);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
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

    public Usuario upgradeCategoria(long codUsuario){
        Usuario u;
        Categoria categoria;
        try{

            u=servicioUsuarioDao.obtenerUsuarioPorCodigo(codUsuario);

            if(u==null){
                throw new Exception("No se encontró al usuario con ID " + codUsuario);
            }

            if(u.getCategoria().getCodigo().equals("02")){
                throw  new Exception("El usuario con ID " + codUsuario + " y es PREMIUM.");
            }
            categoria= new Categoria();
            categoria.setCodigo("02"); //premium
            u.setCategoria(categoria);
            u=servicioUsuarioDao.modificar(u);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al validar datos de Usuario.\nDetalle: " + e.getMessage());
        }
        return u;
    }


    private void enviarMensajeBienvenida(Usuario usuario){
        Email email= new Email();
        List<String> listaPara= new ArrayList<>();
        List<String> listaCc= new ArrayList<>();
        List<String> listaBcc= new ArrayList<>();
        String mensaje;
        listaPara.add(usuario.getEmail());

        mensaje="";
        mensaje +="Estimado(a) " + usuario.getNombre().toUpperCase().trim() + " " + usuario.getApellidoPaterno() + " " + usuario.getApellidoMaterno() +".\n";
        mensaje +="\n";
        mensaje+="Te damos la bienvenida a la mejor aplicación de reportes contra incidentes. Con nosotros podrás sentirte más seguro vayas donde vayas, con nuestro sistema de prevención contra incidentes.";
        mensaje+="\n";
        mensaje+="Tu seguridad es lo más importante, no espere más y aproveche todos las funcionalidades de Report-incidents";
        mensaje +="Atte.\nEl equipo de Reporte de incidentes";

        email.setAsunto("Bienvenido a la aplicación 'Reporteamos Todos!'");
        email.setPara(listaPara);
        email.setCc(listaCc);
        email.setBcc(listaBcc);
        email.setConFormatoHtml(true);
        email.setDe("no-reply@report-incident.com");
        email.setMensaje(this.normalizarMensajeHtml( mensaje));
        //servicioUtilitario.enviarCorreo(email);
        servicioUtilitario.sendEmail(email);

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
