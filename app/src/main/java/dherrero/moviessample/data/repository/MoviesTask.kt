package dherrero.moviessample.data.repository

import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.errors.Either
import dherrero.moviessample.data.rest.TheMoviedbApi
import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.domain.usecases.UseCase
import javax.inject.Inject

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.data.repository
 *
 * Created by dherrero on 15/06/18.
 */
class MoviesTask @Inject constructor(private val theMoviedbApi: TheMoviedbApi): UseCase<List<Movie>, UseCase.None>(){


    override suspend fun run(params: None) = getMovies()


    private fun getMovies(): Either<CustomError, List<Movie>> {


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