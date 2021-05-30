package com.upc.springfield.negocio;

import com.upc.springfield.dao.ServicioTipoIncidenciaDao;
import com.upc.springfield.entidades.TipoIncidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioTipoIncidenciaCore {
    @Autowired
    private ServicioTipoIncidenciaDao servicioTipoIncidenciaDao;

    public TipoIncidencia registrarTipoIncidencia(TipoIncidencia tipoIncidencia){
        TipoIncidencia ti;
        try{
            ti=servicioTipoIncidenciaDao.registrar(tipoIncidencia);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al registrar Tipo de Incidencia.\nDetalle: " + e.getMessage());
        }
        return ti;
    }

    public List<TipoIncidencia> listarTiposIncidencia(){
        List<TipoIncidencia> lista= new ArrayList<>();
        try{
            lista=servicioTipoIncidenciaDao.listarTiposIncidencia();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al listar Tipos de Incidencia.\nDetalle: " + e.getMessage());
        }
        return lista;
    }
}
