package com.upc.springfield.entidades;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = "TB_IMAGEN")
public class Imagen implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_IMAGEN")
    private Long codigo;
    @NotNull
    @Lob
    private Blob archivo;
    @ManyToOne
    @JoinColumn(name="CODIGO_INCIDENCIA")
    private Incidencia incidencia;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }

    public Blob getArchivo() {
        return archivo;
    }

    public void setArchivo(Blob archivo) {
        this.archivo = archivo;
    }

    public Imagen() {
        this.codigo = Long.parseLong("0");
        this.archivo = null;
        this.incidencia = new Incidencia();
    }
}
