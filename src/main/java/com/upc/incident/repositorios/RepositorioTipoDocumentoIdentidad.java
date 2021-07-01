package com.upc.incident.repositorios;

import com.upc.incident.entidades.TipoDocumentoIdentidad;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioTipoDocumentoIdentidad extends CrudRepository<TipoDocumentoIdentidad,String> {
}
