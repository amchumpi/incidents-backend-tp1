package com.upc.springfield.entidades;

import java.util.List;

public class Email {
    private String de;
    private List<String> para;
    private List<String> cc;
    private List<String> bcc;
    private String asunto;
    private String mensaje;
    private boolean conFormatoHtml;

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public List<String> getPara() {
        return para;
    }

    public void setPara(List<String> para) {
        this.para = para;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isConFormatoHtml() {
        return conFormatoHtml;
    }

    public void setConFormatoHtml(boolean conFormatoHtml) {
        this.conFormatoHtml = conFormatoHtml;
    }
}
