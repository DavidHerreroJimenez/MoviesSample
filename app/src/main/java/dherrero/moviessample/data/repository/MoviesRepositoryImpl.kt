package dherrero.moviessample.data.repository

import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.errors.Either
import dherrero.moviessample.data.rest.TheMoviedbApi
import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.domain.model.Movies
import dherrero.moviessample.domain.usecases.UseCase
import javax.inject.Inject

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.data
 *
 * Created by dherrero on 12/06/18.
 */
class MoviesRepositoryImpl @Inject constructor(private val theMoviedbApi: TheMoviedbApi): MoviesRepository{


//    suspend fun run() = getMovies()




    override
    fun getMovies(): Either<CustomError, Movies> {


        return try{
            val moviesResponse = theMoviedbApi.listMovies().execute()

            when (moviesResponse.isSuccessful) {
                true -> Either.Right(moviesResponse.body() ?: Movies())
                false -> Either.Left(CustomError.ErrorServer())

            }
        }catch(exception: Exception){
            Either.Left(CustomError.ErrorServer())
        }

    }

}
