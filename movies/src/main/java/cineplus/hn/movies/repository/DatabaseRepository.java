package cineplus.hn.movies.repository;

import cineplus.hn.movies.model.Movie;
import cineplus.hn.movies.model.PeliculasResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface DatabaseRepository {
    @Headers({
        "Accept: application/vnd.github.v3.full+json",
        "User-Agent: Retrofit-Sample-App"
    })
    @GET("/pls/apex/ingenieria_uth/appcine/peliculas")
    Call<PeliculasResponse> listMovies();

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @POST("/pls/apex/ingenieria_uth/appcine/peliculas")
    Call<ResponseBody> createMovie(@Body Movie movie);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @PUT("/pls/apex/ingenieria_uth/appcine/peliculas")
    Call<ResponseBody> updateMovie(@Body Movie movie);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @DELETE("/pls/apex/ingenieria_uth/appcine/peliculas")
    Call<ResponseBody> deleteMovie(@Query("id") int id);
}
