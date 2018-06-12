package dherrero.moviessample.data.repository

import dherrero.moviessample.data.rest.ThemoviedbApi
import dherrero.moviessample.model.Movie
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.data.repository
 *
 * Created by dherrero on 13/06/18.
 */
@Singleton
class MoviesService @Inject constructor(retrofit: Retrofit): ThemoviedbApi{
    private val themoviedbApi by lazy { retrofit.create(ThemoviedbApi::class.java) }

    override fun getMovies(){
        return themoviedbApi.getMovies()    
    }



    fun moviesFromServer(): List<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}