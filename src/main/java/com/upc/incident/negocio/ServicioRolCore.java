package com.upc.incident.negocio;

import com.upc.incident.dao.ServicioRolDao;
import com.upc.incident.entidades.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioRolCore {
    @Autowired
    private ServicioRolDao servicioRolDao;

    public Rol registrarRol(Rol rol){
        Rol r;
        try{
            r=servicioRolDao.registrar(rol);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al registrar Rol.\nDetalle: " + e.getMessage());
        }
        return r;
    }

    public List<Rol> listarRoles(){
        List<Rol> lista= new ArrayList<>();
        try{
            lista=servicioRolDao.listarRoles();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al listar Roles.\nDetalle: " + e.getMessage());
        }
        return lista;
    }

}
