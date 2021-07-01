package com.upc.incident.dao;

import com.upc.incident.entidades.TipoIncidencia;
import com.upc.incident.repositorios.RepositorioTipoIncidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioTipoIncidenciaDao {
    @Autowired
    private RepositorioTipoIncidencia repositorioTipoIncidencia;

    public TipoIncidencia registrar(TipoIncidencia tipoIncidencia){
        return repositorioTipoIncidencia.save(tipoIncidencia);
    }

    public List<TipoIncidencia> listarTiposIncidencia(){
        List<TipoIncidencia> lista;
        lista=(List<TipoIncidencia>)repositorioTipoIncidencia.findAll();
        return lista;
    }
}
