package cineplus.hn.movies.view;

import cineplus.hn.movies.model.Movie;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("MoviesBean")
@ViewScoped
public class MoviesBean implements Serializable, PeliculasViewModel {
    private List<Movie> movies;
    private List<Movie> selectedMovies;
    private Movie selectedMovie;

    public MoviesBean() {
        this.movies = new ArrayList<>();
        this.selectedMovies = new ArrayList<>();
        this.selectedMovie = null;
    }

    public void openNew() {
        this.selectedMovie = new Movie();
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedMovie()) {
            int size = this.selectedMovies.size();
            return size > 1 ? size + " peliculas seleccionadas" : "1 pelicula seleccionada";
        }

        return "Eliminar";
    }

    public boolean hasSelectedMovie() {
        return this.selectedMovies != null && !this.selectedMovies.isEmpty();
    }

    public void guardarPelicula() {

    }


    public void eliminarPelicula() {
        this.movies.remove(this.selectedMovie);
        this.selectedMovie = null;
        mostrarMensaje("Pelicula eliminada correctamente!", FacesMessage.SEVERITY_INFO);
    }

    public void eliminarPeliculas() {
        this.movies.removeAll(this.selectedMovies);
        this.selectedMovies = null;
        mostrarMensaje("Peliculas eliminadas correctamente!", FacesMessage.SEVERITY_INFO);
    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity tipo) {
        FacesMessage message = new FacesMessage(tipo, mensaje, null);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Movie getSelectedMovie() {
        return selectedMovie;
    }

    public void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }

    public List<Movie> getSelectedMovies() {
        return selectedMovies;
    }

    public void setSelectedMovies(List<Movie> selectedMovies) {
        this.selectedMovies = selectedMovies;
    }

    @Override
    public void mostrarPeliculasDataTable(List<Movie> peliculas) {
        this.movies = peliculas;
    }

    @Override
    public void mostrarMensajeExito(String mensaje) {
        mostrarMensaje(mensaje, FacesMessage.SEVERITY_INFO);
    }

    @Override
    public void mostrarMensajeError(String mensaje) {
        mostrarMensaje(mensaje, FacesMessage.SEVERITY_ERROR);
    }
}
