package com.upc.incident.rest;

import com.upc.incident.entidades.TipoDocumentoIdentidad;
import com.upc.incident.negocio.ServicioTipoDocumentoIdentidadCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class ServicioTipoDocumentoIdentidadRest {
    @Autowired
    private ServicioTipoDocumentoIdentidadCore servicioTipoDocumentoIdentidadCore;

    @PostMapping("/tipoDocumentoIdentidad")
    public TipoDocumentoIdentidad registrar(@RequestBody TipoDocumentoIdentidad tipoDocumentoIdentidad){
        return servicioTipoDocumentoIdentidadCore.registrarTipoDocumentoIdentidad(tipoDocumentoIdentidad);
    }

    @GetMapping("/tipoDocumentoIdentidad/listar")
    public List<TipoDocumentoIdentidad> listarTiposDocumentoIdentidad(){
        return servicioTipoDocumentoIdentidadCore.listarTiposDocumentoIdentidad();
    }
}
