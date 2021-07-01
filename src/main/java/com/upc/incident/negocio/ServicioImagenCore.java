package com.upc.incident.negocio;

import com.upc.incident.dao.ServicioImagenDao;
import com.upc.incident.entidades.Imagen;
import com.upc.incident.entidades.Incidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioImagenCore {
    @Autowired
    private ServicioImagenDao servicioImagenDao;

    public List<Imagen> RegistrarImagen(Long codIncidencia, MultipartFile[] imagenes){
        Imagen i= new Imagen();
        Incidencia incidencia;
        Imagen imagen;

        List<Imagen> listaImagen=new ArrayList<>();
        incidencia= new Incidencia();
        incidencia.setCodigo(codIncidencia);

        try {
            for (MultipartFile file : imagenes) {
                i = new Imagen();
                i.setIncidencia(incidencia);
                byte[] data=file.getBytes();
                Blob archivo=new javax.sql.rowset.serial.SerialBlob(data);
                i.setArchivo(archivo);
                imagen = servicioImagenDao.RegistrarImagen(i);
                listaImagen.add(imagen);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al registrar imagenes.\nDetalle: " + e.getMessage());
        }
        return listaImagen;
    }
}
