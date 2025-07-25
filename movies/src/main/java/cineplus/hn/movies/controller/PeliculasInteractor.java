package cineplus.hn.movies.controller;

import cineplus.hn.movies.model.Movie;

public interface PeliculasInteractor {
    void consultarPeliculas();
    void crearPelicula(Movie pelicula);
    void actualizarPelicula(Movie pelicula);
    void eliminarPelicula(int id);
}
