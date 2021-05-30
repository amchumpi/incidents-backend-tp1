package com.upc.springfield.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_COMENTARIO_INCIDENCIA")
public class ComentarioIncidencia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_COMENT_INCIDENCIA")
    private Long codigo;
    private String comentario;
    @ManyToOne
    @JoinColumn(name="CODIGO_INCIDENCIA")
    private Incidencia incidencia;
    @OneToOne
    @JoinColumn(name="CODIGO_USUARIO")
    @JsonIgnore
    private Usuario usuario;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
