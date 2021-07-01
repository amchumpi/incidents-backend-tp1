package com.upc.incident.repositorios;

import com.upc.incident.entidades.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioCategoria extends CrudRepository<Categoria,String> {
}
