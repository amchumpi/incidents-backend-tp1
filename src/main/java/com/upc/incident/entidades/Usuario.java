package com.upc.incident.entidades;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
@Proxy(lazy = false)
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_USUARIO")
    private Long codigo;
    @JoinColumn(name="CODIGO_TIPO_DOC_IDENTIDAD")
    private TipoDocumentoIdentidad tipoDocIdentidad;
    private String nroDocIdentidad;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    //private String direccion;
    //private String distrito;
    //private String provincia;
    //private String departamento;
    @Email
    private String email;
    private String password;
    @OneToMany(mappedBy="usuario", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Incidencia> incidencias;
    @OneToOne
    @JoinColumn(name="CODIGO_ROL")
    private Rol rol;
    @OneToOne
    @JoinColumn(name="CODIGO_CATEGORIA")
    private Categoria categoria;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNroDocIdentidad() {
        return nroDocIdentidad;
    }

    public void setNroDocIdentidad(String nroDocIdentidad) {
        this.nroDocIdentidad = nroDocIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /*public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

     */

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //public List<Incidencia> getIncidencias() {
    //    return incidencias;
    //}

    public void setIncidencias(List<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }

    public TipoDocumentoIdentidad getTipoDocIdentidad() {
        return tipoDocIdentidad;
    }

    public void setTipoDocIdentidad(TipoDocumentoIdentidad tipoDocIdentidad) {
        this.tipoDocIdentidad = tipoDocIdentidad;
    }

    //public List<Incidencia> getIncidencias() {
    //    return incidencias;
    //}

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario() {
        this.nroDocIdentidad = "";
        this.nombre = "";
        this.apellidoPaterno = "";
        this.apellidoMaterno = "";
        this.fechaNacimiento = null;
        /*
        this.direccion = "";
        this.distrito = "";
        this.provincia = "";
        this.departamento = "";
         */
        this.email = "";
        this.password = "";
        this.incidencias = new ArrayList<>();
        this.rol = new Rol();
        this.tipoDocIdentidad=new TipoDocumentoIdentidad();
        this.categoria= new Categoria();
    }
}
