package dherrero.moviessample.data.errors

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.data.errors
 *
 * Created by dherrero on 12/06/18.
 */
sealed class CustomError{
    class ErrorServer: CustomError()
}