package com.upc.springfield.negocio;

import com.upc.springfield.dao.ServicioIncidenciaDao;
import com.upc.springfield.entidades.Imagen;
import com.upc.springfield.entidades.ImagenEntity;
import com.upc.springfield.entidades.Incidencia;
import com.upc.springfield.entidades.IncidenciaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioIncidenciaCore {
    @Autowired
    private ServicioIncidenciaDao servicioIncidenciaDao;

    public Incidencia registrarIncidencia(Incidencia incidencia){
        Incidencia i;
        try{
            i=servicioIncidenciaDao.registrar(incidencia);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al registrar Incidencia.\nDetalle: " + e.getMessage());
        }
        return i;
    }

    public Incidencia modificarIncidencia(Incidencia incidencia){
        Incidencia i;
        try{
            if(incidencia.getCodigo()!=null)
                if(incidencia.getCodigo()!=0)
                    i=servicioIncidenciaDao.modificar(incidencia);
                else
                    throw new Exception("La incidencia tiene código 0.)");
            else
                throw new Exception("la incidencia no tiene código(nulo).");
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al modificar Incidencia.\nDetalle: " + e.getMessage());
        }
        return i;
    }

    public List<Incidencia> listarIncidenciasUsuario(Long usuario){
        List<Incidencia> lista= new ArrayList<>();
        try{
            lista=servicioIncidenciaDao.listarIncidenciasPorUsuario(usuario);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al listar Incidencias por usuario.\nDetalle: " + e.getMessage());
        }
        return lista;
    }

    public List<IncidenciaEntity> listarIncidencias(){
        List<Incidencia> lista= new ArrayList<>();
        List<IncidenciaEntity> listaIncidencia=new ArrayList<>();
        IncidenciaEntity incEntity=null;
        ImagenEntity imgEntity=null;
        List<ImagenEntity> listaImgEntity= new ArrayList<>();
        byte[] file=null;
        int lng;
        try{
            lista=servicioIncidenciaDao.listarIncidencias();

            for(Incidencia inc:lista){
                incEntity= new IncidenciaEntity();
                incEntity.setCodigo(inc.getCodigo());
                incEntity.setComentarios(inc.getComentarios());
                incEntity.setDescripcion(inc.getDescripcion());
                incEntity.setDireccion(inc.getDireccion());
                incEntity.setDistrito(inc.getDistrito());
                incEntity.setEstado(inc.getEstado());
                incEntity.setFechaCreacion(inc.getFechaCreacion());
                incEntity.setPais(inc.getPais());
                incEntity.setProvincia(inc.getPais());
                incEntity.setTipo(inc.getTipo());
                listaImgEntity= new ArrayList<>();
                for(Imagen img:inc.getImagenes()){
                    imgEntity= new ImagenEntity();
                    imgEntity.setCodigo(img.getCodigo());
                    //imgEntity.setIncidencia();
                    lng=(int)img.getArchivo().length();
                    file=img.getArchivo().getBytes(1,lng);
                    imgEntity.setArchivo(file);
                    listaImgEntity.add(imgEntity);
                }
                incEntity.setImagenes(listaImgEntity);
                //incEntity.setUsuario();
                listaIncidencia.add(incEntity);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al listar Incidencias.\nDetalle: " + e.getMessage());
        }
        return listaIncidencia;
    }

    public IncidenciaEntity obtenerIncidenciaPorId(Long id){
        Incidencia incidencia=servicioIncidenciaDao.obtenerIncidenciaPorId(id);
        IncidenciaEntity incidenciaEntity= new IncidenciaEntity();
        ImagenEntity imgEntity=null;
        List<ImagenEntity> listaImgEntity= new ArrayList<>();
        byte[] file=null;
        int lng;
        try {
            incidenciaEntity= new IncidenciaEntity();
            incidenciaEntity.setCodigo(incidencia.getCodigo());
            incidenciaEntity.setComentarios(incidencia.getComentarios());
            incidenciaEntity.setDescripcion(incidencia.getDescripcion());
            incidenciaEntity.setDireccion(incidencia.getDireccion());
            incidenciaEntity.setDistrito(incidencia.getDistrito());
            incidenciaEntity.setEstado(incidencia.getEstado());
            incidenciaEntity.setFechaCreacion(incidencia.getFechaCreacion());
            incidenciaEntity.setPais(incidencia.getPais());
            incidenciaEntity.setProvincia(incidencia.getPais());
            incidenciaEntity.setTipo(incidencia.getTipo());
            listaImgEntity = new ArrayList<>();
            for (Imagen img : incidencia.getImagenes()) {
                imgEntity = new ImagenEntity();
                imgEntity.setCodigo(img.getCodigo());
                lng = (int) img.getArchivo().length();
                file = img.getArchivo().getBytes(1, lng);
                imgEntity.setArchivo(file);
                listaImgEntity.add(imgEntity);
            }
            incidenciaEntity.setImagenes(listaImgEntity);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al obtener Incidencia por Id.\nDetalle: " + e.getMessage());
        }
        return incidenciaEntity;
    }
}
