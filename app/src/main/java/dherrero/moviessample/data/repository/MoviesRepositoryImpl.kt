package dherrero.moviessample.data.repository

import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.errors.Either
import dherrero.moviessample.data.rest.TheMoviedbApi
import dherrero.moviessample.data.rest.entities.ThemoviedbList1
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.data
 *
 * Created by dherrero on 12/06/18.
 */
@Singleton
class MoviesRepositoryImpl @Inject constructor(private val theMoviedbApi: TheMoviedbApi) : MoviesRepository {


    override
    fun getMovies(): Either<CustomError, ThemoviedbList1> {


        return try {
            val moviesResponse = theMoviedbApi.listMovies().execute()

            val customError = CustomError.ErrorServer()

            customError.errorMessage = moviesResponse.message().toString()

            customError.urlError = moviesResponse.raw().request().url().toString()

            when (moviesResponse.isSuccessful) {
                true -> Either.Right(moviesResponse.body() ?: ThemoviedbList1())
                false -> Either.Left(customError)

            }
        } catch (exception: Exception) {

            val customError = CustomError.ErrorServer()

            customError.errorMessage = exception.message!!

            Either.Left(customError)
        }

    }

}
