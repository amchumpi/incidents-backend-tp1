package com.upc.springfield.repositorios;

import com.upc.springfield.entidades.Incidencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositorioIncidencia extends CrudRepository<Incidencia,Long> {
    @Query("select i from Incidencia i where i.usuario=:usuario")
    public List<Incidencia> listarIncidenciasPorUsuario(@Param(value = "usuario") Long usuario);
    @Query("select i from Incidencia i where i.codigo=:codincidencia")
    public Incidencia obtenerIncidenciasPorId(@Param(value = "codincidencia") Long codincidencia);

}
