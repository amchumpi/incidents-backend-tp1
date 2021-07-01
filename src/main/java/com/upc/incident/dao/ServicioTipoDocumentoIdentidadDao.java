package com.upc.incident.dao;

import com.upc.incident.entidades.TipoDocumentoIdentidad;
import com.upc.incident.repositorios.RepositorioTipoDocumentoIdentidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioTipoDocumentoIdentidadDao {

    @Autowired
    private RepositorioTipoDocumentoIdentidad repositorioTipoDocumentoIdentidad;

    public TipoDocumentoIdentidad registrar(TipoDocumentoIdentidad tipoDocumentoIdentidad){
        return repositorioTipoDocumentoIdentidad.save(tipoDocumentoIdentidad);
    }

    public List<TipoDocumentoIdentidad> listarTiposDocumentoIdentidad(){
        List<TipoDocumentoIdentidad> lista;
        lista=(List<TipoDocumentoIdentidad>)repositorioTipoDocumentoIdentidad.findAll();
        return lista;
    }

}
