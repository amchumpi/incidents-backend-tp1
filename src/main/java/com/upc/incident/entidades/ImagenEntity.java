package com.upc.incident.entidades;


import java.io.Serializable;

public class ImagenEntity implements Serializable {

    private Long codigo;
    private byte[] archivo;
    private Incidencia incidencia;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }
}
