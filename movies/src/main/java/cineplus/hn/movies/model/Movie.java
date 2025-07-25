package cineplus.hn.movies.model;

import java.io.Serializable;

public class Movie implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private int estreno;
    private String director;
    private String duracion;
    private String genero;
    private String portada;

    public Movie() {
        this.id = 0;
        this.nombre = "";
        this.descripcion = "";
        this.estreno = 0;
        this.director = "";
        this.duracion = "";
        this.genero = "";
        this.portada = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstreno() {
        return estreno;
    }

    public void setEstreno(int estreno) {
        this.estreno = estreno;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}
