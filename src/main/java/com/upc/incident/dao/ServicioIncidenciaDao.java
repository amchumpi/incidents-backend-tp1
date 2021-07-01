package com.upc.incident.dao;

import com.upc.incident.entidades.Incidencia;
import com.upc.incident.repositorios.RepositorioIncidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioIncidenciaDao {
    @Autowired
    private RepositorioIncidencia repositorioIncidencia;

    public Incidencia registrar(Incidencia incidencia){
        Incidencia i;
        i=repositorioIncidencia.save(incidencia);
        return i;
    }

    public Incidencia modificar(Incidencia incidencia){
        Incidencia i;
        i=repositorioIncidencia.save(incidencia);
        return i;
    }

    public List<Incidencia> listarIncidenciasPorUsuario(Long usuario){
        return repositorioIncidencia.listarIncidenciasPorUsuario(usuario);
    }

    public List<Incidencia> listarIncidencias(){
        List<Incidencia> listaIncidencia=new ArrayList<>();
        listaIncidencia= (List<Incidencia>)repositorioIncidencia.findAll();
        return listaIncidencia;
    }

    public Incidencia obtenerIncidenciaPorId(Long id){
        Incidencia incidencia;
        incidencia=repositorioIncidencia.obtenerIncidenciasPorId(id);
        return incidencia;
    }
}
