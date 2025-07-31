package cineplus.hn.movies.repository;

import cineplus.hn.movies.model.Movie;
import cineplus.hn.movies.model.PeliculasResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class DatabaseRepositoryImpl {
    private static DatabaseRepositoryImpl instance;
    private DatabaseClient client;

    private DatabaseRepositoryImpl(String url, Long timeout){
        client = new DatabaseClient(url, timeout);
    }

    //PATRON SINGLETON
    public static DatabaseRepositoryImpl getInstance(String url, Long timeout){
        if(instance == null){
            synchronized (DatabaseRepositoryImpl.class){
                if(instance == null){
                    instance = new DatabaseRepositoryImpl(url, timeout);
                }
            }
        }
        return instance;
    }

    public PeliculasResponse consultarPeliculas() throws IOException {
        Call<PeliculasResponse> call = client.getInstance().listMovies();
        Response<PeliculasResponse> response = call.execute();//EJECUTA EL LLAMADO A LA BASE DE DATOS
        if(response.isSuccessful()){//CODIGO (STATUS CODE HTTP 200)
            return response.body();
        }else{
            return null;
        }
    }

    public boolean crearPeliculas(Movie nueva) throws IOException {
        Call<ResponseBody> call = client.getInstance().createMovie(nueva);
        Response<ResponseBody> response = call.execute();//EJECUTA EL LLAMADO A LA BASE DE DATOS
        return response.isSuccessful();
    }

    public boolean actualizarPeliculas(Movie existente) throws IOException {
        Call<ResponseBody> call = client.getInstance().updateMovie(existente);
        Response<ResponseBody> response = call.execute();//EJECUTA EL LLAMADO A LA BASE DE DATOS
        return response.isSuccessful();
    }

    public boolean eliminarPeliculas(int id) throws IOException {
        Call<ResponseBody> call = client.getInstance().deleteMovie(id);
        Response<ResponseBody> response = call.execute();//EJECUTA EL LLAMADO A LA BASE DE DATOS
        return response.isSuccessful();
    }
}
