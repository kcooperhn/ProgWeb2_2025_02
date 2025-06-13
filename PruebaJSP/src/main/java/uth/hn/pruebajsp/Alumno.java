package uth.hn.pruebajsp;

public class Alumno {
    private String nombre;
    private String apellido;
    private String email;
    private String identidad;

    public Alumno(String nombre, String apellido, String email, String identidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.identidad = identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentidad() {
        return identidad;
    }

    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }
}
