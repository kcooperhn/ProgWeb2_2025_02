package cineplus.hn.movies.controller;

import cineplus.hn.movies.model.Movie;
import cineplus.hn.movies.model.PeliculasResponse;
import cineplus.hn.movies.repository.DatabaseRepository;
import cineplus.hn.movies.repository.DatabaseRepositoryImpl;
import cineplus.hn.movies.view.PeliculasViewModel;

public class PeliculasInteractorImpl implements PeliculasInteractor {
    private DatabaseRepositoryImpl repositorio;
    private PeliculasViewModel vista;

    public PeliculasInteractorImpl(PeliculasViewModel vista) {
        super();
        this.vista = vista;
        this.repositorio = DatabaseRepositoryImpl.getInstance("https://apex.oracle.com", 3L);
    }

    @Override
    public void consultarPeliculas() {
        try{
            PeliculasResponse response = this.repositorio.consultarPeliculas();
            if(response == null || response.getItems() == null || response.getItems().isEmpty() || response.getCount() == 0){
                this.vista.mostrarMensajeError("No se encontraron peliculas");
            }else{
                this.vista.mostrarPeliculasDataTable(response.getItems());
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void crearPelicula(Movie pelicula) {
        try{
            boolean creado = this.repositorio.crearPeliculas(pelicula);
            if(creado){
                this.vista.mostrarMensajeExito("Pelicula creada correctamente!");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al crear la pelicula");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void actualizarPelicula(Movie pelicula) {
        try{
            boolean modificado = this.repositorio.actualizarPeliculas(pelicula);
            if(modificado){
                this.vista.mostrarMensajeExito("Pelicula actualizada correctamente!");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al actualizar la pelicula");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void eliminarPelicula(int id) {
        try{
            boolean eliminado = this.repositorio.eliminarPeliculas(id);
            if(eliminado){
                this.vista.mostrarMensajeExito("Pelicula eliminada correctamente!");
                this.vista.refrescarPantalla();
            }else{
                this.vista.mostrarMensajeError("Error al eliminar la pelicula");
            }
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    @Override
    public void eliminarPeliculas(int[] ids) {
        try{
            for(int id : ids){
                boolean eliminado = this.repositorio.eliminarPeliculas(id);
                if(!eliminado){
                    this.vista.mostrarMensajeError("Error al eliminar la pelicula");
                    this.vista.refrescarPantalla();
                    return;
                }
            }
            this.vista.mostrarMensajeExito("Pelicula eliminada correctamente!");
            this.vista.refrescarPantalla();
        }catch(Exception error){
            error.printStackTrace();
        }
    }
}
