package com.upc.springfield.repositorios;

import com.upc.springfield.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RepositorioUsuario extends CrudRepository<Usuario,Long> {
    @Query("Select u from Usuario u where u.email=:email and u.password=:password")
    public Usuario validarUsuario(@Param("email") String email,@Param("password") String password);
    @Query("Select u from Usuario u where u.email=:email")
    public Usuario obtenerUsuarioPorEmail(@Param("email") String email);

}
