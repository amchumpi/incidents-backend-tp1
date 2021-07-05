package com.upc.incident.repositorios;

import com.upc.incident.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RepositorioUsuario extends CrudRepository<Usuario,Long> {
    @Query("Select u from Usuario u where u.email=:email and u.password=:password")
    public Usuario validarUsuario(@Param("email") String email,@Param("password") String password);
    @Query("Select u from Usuario u where u.email=:email")
    public Usuario obtenerUsuarioPorEmail(@Param("email") String email);
    @Query("Select u from Usuario u where u.codigo=:codigo")
    public Usuario obtenerUsuarioPorCodigo(@Param("codigo") long codigo);


}
