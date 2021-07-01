package com.upc.incident.repositorios;

import com.upc.incident.entidades.TipoIncidencia;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioTipoIncidencia extends CrudRepository<TipoIncidencia,String> {
}
