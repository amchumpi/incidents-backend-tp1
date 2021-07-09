package com.upc.incident.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class IncidenciaEntity implements Serializable {

    private Long codigo;
    private TipoIncidencia tipo;
    private String descripcion;
    private String direccion;
    private String distrito;
    private String provincia;
    private String pais;
    private String estado;
    private Usuario usuario;
    private List<ComentarioIncidencia> comentarios;
    private List<ImagenEntity> imagenes;
    private Double latitud;
    private Double longitud;
    private Date fecha;

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
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

    public List<ImagenEntity> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<ImagenEntity> imagenes) {
        this.imagenes = imagenes;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
