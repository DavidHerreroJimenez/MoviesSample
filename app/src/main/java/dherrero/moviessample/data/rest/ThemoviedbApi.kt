package dherrero.moviessample.data.rest

import dherrero.moviessample.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.data.rest
 *
 * Created by dherrero on 12/06/18.
 */
internal interface ThemoviedbApi{

    @Header("Content-Type: application/json;charset=utf-8")
    @GET("/list/{list_id}")
    fun getMovies(@Header(" \"Authorization: Bearer {‘93aea0c77bc168d8bbce3918cefefa45’}\"")): Call<List<MovieEntity>>

    fun moviesFromServer(): List<Movie>


}