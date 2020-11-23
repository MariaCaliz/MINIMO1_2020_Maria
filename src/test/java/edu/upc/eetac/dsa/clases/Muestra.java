package edu.upc.eetac.dsa.clases;
import org.junit.Before;

import java.util.LinkedList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Muestra {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    String idMuestra;
    String idClinico;
    String idPersona;
    Date fechaExtraccion;
    String idLaboratorio;
    String resultado;
    String comentario;

    public Muestra(String idMuestra, String idClinico, String idPersona,Date fechaExtraccion, String idLaboratorio, String resultado, String comentario){
        this.idMuestra= idMuestra;
        this.idClinico = idClinico;
        this.idPersona = idPersona;
        this.fechaExtraccion = fechaExtraccion;
        this.idLaboratorio = idLaboratorio;
        this.resultado = resultado;
        this.comentario = comentario;
    }


    public void setIdMuestra(String idMuestra) {
        this.idMuestra = idMuestra;
    }

    public String getIdMuestra() {
        return idMuestra;
    }

    public String getIdClinico() {
        return idClinico;
    }

    public void setIdClinico(String idClinico) {
        this.idClinico = idClinico;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public Date getFechaExtraccion() {
        return fechaExtraccion;
    }

    public void setFechaExtraccion(Date fechaExtraccion) {
        this.fechaExtraccion = fechaExtraccion;
    }

    public String getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(String idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public SimpleDateFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(SimpleDateFormat formatter) {
        this.formatter = formatter;
    }
}
