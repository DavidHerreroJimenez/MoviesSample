package dherrero.moviessample.data.repository

import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.errors.Either
import dherrero.moviessample.model.Movie
import javax.inject.Inject

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.data
 *
 * Created by dherrero on 12/06/18.
 */
class MoviesRepositoryImpl @Inject constructor(private val moviesService: MoviesService): MoviesRepository {

    override fun getMovies(): Either<CustomError, List<Movie>> {


        return try{
        val response = moviesService.execute()

        when (response.isSuccessful) {
            true -> Either.Right(transform((response.body() ?: default)))
            false -> Either.Left(CustomError.ErrorServer())
            return moviesService.
        }
        }catch(exception: Exception){
                Either.Left<CustomError.ErrorServer>()
            }}

    }
}