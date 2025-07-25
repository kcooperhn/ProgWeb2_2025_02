package cineplus.hn.movies.view;

import cineplus.hn.movies.model.Movie;

import java.util.List;

public interface PeliculasViewModel {
    void mostrarPeliculasDataTable(List<Movie> peliculas);
    void mostrarMensajeExito(String mensaje);
    void mostrarMensajeError(String mensaje);
}
