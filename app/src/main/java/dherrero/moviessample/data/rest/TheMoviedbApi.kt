package dherrero.moviessample.data.rest

import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.domain.model.Movies
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.data.rest
 *
 * Created by dherrero on 13/06/18.
 */
@Singleton
class TheMoviedbApi @Inject constructor(retrofit: Retrofit):ThemoviedbService{

    private val movies by lazy { retrofit.create(ThemoviedbService::class.java) }


    override fun listMovies(): Call<Movies> {
        return movies.listMovies()
    }
}