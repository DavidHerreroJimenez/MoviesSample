package dherrero.moviessample.data.rest


import dherrero.moviessample.data.rest.entities.ThemoviedbList1
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.data.rest
 *
 * Created by dherrero on 12/06/18.
 */
interface ThemoviedbService {


    @GET("1?")
    fun listMovies(@Query("api_key") api_key: String): Call<ThemoviedbList1>





}
