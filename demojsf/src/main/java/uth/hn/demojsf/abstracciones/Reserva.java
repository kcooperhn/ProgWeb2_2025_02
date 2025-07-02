package uth.hn.demojsf.abstracciones;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reserva implements Serializable {
    private String identidad;
    private String nombre;
    private String salon;
    private String inicio;
    private String fin;

    public Reserva() {
        this.identidad = "";
        this.nombre = "";
        this.salon = "";
        this.inicio = "";
        this.fin = "";
    }

    public Reserva(String identidad, String nombre, String salon, String inicio, String fin) {
        this.identidad = identidad;
        this.nombre = nombre;
        this.salon = salon;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}
