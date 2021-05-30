package com.upc.springfield.repositorios;

import com.upc.springfield.entidades.TipoIncidencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioTipoIncidencia extends CrudRepository<TipoIncidencia,String> {
}
