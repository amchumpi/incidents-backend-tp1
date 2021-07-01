package com.upc.incident.negocio;

import com.upc.incident.dao.ServicioTipoDocumentoIdentidadDao;
import com.upc.incident.entidades.TipoDocumentoIdentidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioTipoDocumentoIdentidadCore {
    @Autowired
    private ServicioTipoDocumentoIdentidadDao servicioTipoDocumentoIdentidadDao;

    public TipoDocumentoIdentidad registrarTipoDocumentoIdentidad(TipoDocumentoIdentidad tipoDocumentoIdentidad){
        TipoDocumentoIdentidad ti;
        try{
            ti=servicioTipoDocumentoIdentidadDao.registrar(tipoDocumentoIdentidad);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al registrar Tipo de documento de identidad.\nDetalle: " + e.getMessage());
        }
        return ti;
    }

    public List<TipoDocumentoIdentidad> listarTiposDocumentoIdentidad(){
        List<TipoDocumentoIdentidad> lista= new ArrayList<>();
        try{
            lista=servicioTipoDocumentoIdentidadDao.listarTiposDocumentoIdentidad();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al listar Tipos de Incidencia.\nDetalle: " + e.getMessage());
        }
        return lista;
    }
}
