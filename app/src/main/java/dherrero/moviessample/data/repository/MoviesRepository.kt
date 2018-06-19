package dherrero.moviessample.data.repository

import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.errors.Either
import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.domain.model.Movies

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.data
 *
 * Created by dherrero on 12/06/18.
 */
interface MoviesRepository{

    fun getMovies(): Either<CustomError, Movies>

}