package com.upc.incident.repositorios;

import com.upc.incident.entidades.Incidencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.function.DoubleBinaryOperator;

public interface RepositorioIncidencia extends CrudRepository<Incidencia,Long> {
    @Query("select i from Incidencia i where i.usuario=:usuario")
    public List<Incidencia> listarIncidenciasPorUsuario(@Param(value = "usuario") Long usuario);
    @Query("select i from Incidencia i where i.codigo=:codincidencia")
    public Incidencia obtenerIncidenciasPorId(@Param(value = "codincidencia") Long codincidencia);
    @Query("select i from Incidencia i where ( 6378137 * 2 * atan2(sqrt(sin(radians(:lat - i.latitud) / 2) * sin(radians(:lat - i.latitud) / 2)+cos(radians(i.latitud))*cos(radians((:lat)))* sin(radians(:lon - i.longitud) / 2)* sin(radians(:lon - i.longitud) / 2)), sqrt(1 - sin(radians(:lat - i.latitud) / 2) * sin(radians(:lat - i.latitud) / 2)+cos(radians(i.latitud))*cos(radians(:lat))* sin(radians(:lon - i.longitud) / 2)* sin(radians(:lon - i.longitud) / 2))))<=:d")
    public List<Incidencia> obtenerIncidenciasPorUbicacionYDistancia(@Param(value = "lat")Double lat,@Param(value = "lon") Double lon,@Param(value = "d") int d);
}
