package dherrero.moviessample.data.repository

import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.errors.Either
import dherrero.moviessample.data.rest.TheMoviedbApi
import dherrero.moviessample.model.Movie
import javax.inject.Inject

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.data
 *
 * Created by dherrero on 12/06/18.
 */
class MoviesRepositoryImpl @Inject constructor(private val theMoviedbApi: TheMoviedbApi): MoviesRepository {

    override fun getMovies(): Either<CustomError, List<Movie>> {


        return try{
        val moviesResponse = theMoviedbApi.listMovies().execute()

        when (moviesResponse.isSuccessful) {
            true -> Either.Right(moviesResponse.body() ?: emptyList())
            false -> Either.Left(CustomError.ErrorServer())

        }
        }catch(exception: Exception){
            Either.Left(CustomError.ErrorServer())
            }

    }
}