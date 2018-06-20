package dherrero.moviessample.data.repository

import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.errors.Either
import dherrero.moviessample.data.rest.TheMoviedbApi
import dherrero.moviessample.data.rest.entities.ThemoviedbList1
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
    fun getMovies(): Either<CustomError, ThemoviedbList1> {


        return try{
            val moviesResponse = theMoviedbApi.listMovies().execute()

            when (moviesResponse.isSuccessful) {
                true -> Either.Right(moviesResponse.body() ?: ThemoviedbList1())
                false -> Either.Left(CustomError.ErrorServer())

            }
        }catch(exception: Exception){
            CustomError.ErrorServer().errorMessage = exception.message!!
            Either.Left(CustomError.ErrorServer())
        }

    }

}
