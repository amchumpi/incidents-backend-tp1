package com.upc.incident.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "INCIDENCIA")
public class Incidencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_INCIDENCIA")
    private Long codigo;
    @OneToOne
    @JoinColumn(name="CODIGO_TIPO_INCIDENCIA")
    private TipoIncidencia tipo;
    private String descripcion;
    private String direccion;
    private String distrito;
    private String provincia;
    private String pais;
    private Date fechaCreacion;
    private String estado;
    @ManyToOne
    @JoinColumn(name="CODIGO_USUARIO")
    private Usuario usuario;
    @OneToMany(mappedBy="incidencia", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<ComentarioIncidencia> comentarios;
    @OneToMany(mappedBy="incidencia", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Imagen> imagenes;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoIncidencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoIncidencia tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ComentarioIncidencia> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioIncidencia> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Incidencia() {
        this.codigo = Long.parseLong("0");
        this.tipo = new TipoIncidencia();
        this.descripcion = "";
        this.direccion = "";
        this.distrito = "";
        this.provincia = "";
        this.pais = "";
        this.fechaCreacion = null;
        this.estado = "";
        this.usuario = new Usuario();
        this.comentarios = new ArrayList<>();
        this.imagenes = new ArrayList<>();
    }
}
