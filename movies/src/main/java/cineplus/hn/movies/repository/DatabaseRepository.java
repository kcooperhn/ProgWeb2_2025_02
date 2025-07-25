package cineplus.hn.movies.repository;

import cineplus.hn.movies.model.PeliculasResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface DatabaseRepository {
    @Headers({
        "Accept: application/vnd.github.v3.full+json",
        "User-Agent: Retrofit-Sample-App"
    })
    @GET("/pls/apex/ingenieria_uth/appcine/peliculas")
    Call<PeliculasResponse> listMovies();
}
