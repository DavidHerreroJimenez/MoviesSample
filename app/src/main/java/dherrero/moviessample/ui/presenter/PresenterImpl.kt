package dherrero.moviessample.ui.presenter

import android.app.Activity
import android.view.View
import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.rest.entities.Result
import dherrero.moviessample.data.rest.entities.ThemoviedbList1
import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.domain.usecases.UseCase
import dherrero.moviessample.ui.MoviesFragment
import dherrero.moviessample.ui.view.MoviesFragmentViewCallBack
import javax.inject.Inject

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui.presenter
 *
 * Created by dherrero on 12/06/18.
 */
class PresenterImpl @Inject constructor(val useCase: UseCase<ThemoviedbList1>, val moviesFragment: MoviesFragment): Presenter{

    lateinit var themoviedbList1: ThemoviedbList1
    lateinit var error: CustomError
    lateinit var results:  List<Result>
    var movies: MutableList<Movie> = mutableListOf()




    fun loadMovies(){
        useCase.execute{it.either(::getError, ::addMoviesToMoviesList)}

    }

    fun addMoviesToMoviesList(themoviedbList1: ThemoviedbList1){
        this.themoviedbList1 = themoviedbList1


        results = themoviedbList1.results!!

        for (result in results){
            movies.add(Movie(
                    result.id!!,
                    result.adult!!,
                    result.backdropPath!!,
                    result.mediaType!!,
                    result.originalLanguage!!,
                    result.originalTitle!!,
                    result.overview!!,
                    result.popularity!!,
                    result.posterPath!!,
                    result.releaseDate!!,
                    result.title!!,
                    result.video!!,
                    result.voteAverage!!,
                    result.voteCount!!)
            )
        }

        moviesFragment.onCallBackMoviesFragment(movies)

    }

    fun getError(customError: CustomError){
        this.error = customError
    }

}