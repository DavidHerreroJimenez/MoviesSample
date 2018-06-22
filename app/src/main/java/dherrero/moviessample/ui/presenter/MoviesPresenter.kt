package dherrero.moviessample.ui.presenter

import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.rest.entities.Result
import dherrero.moviessample.data.rest.entities.ThemoviedbList1
import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.domain.usecases.MoviesUseCase
import dherrero.moviessample.ui.base.BasePresenter
import dherrero.moviessample.ui.view.MovieDetailCallBack
import dherrero.moviessample.ui.view.MoviesCallBack
import dherrero.moviessample.ui.view.MoviesFragmentCallBack
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui.presenter
 *
 * Created by dherrero on 12/06/18.
 */
@Singleton
class MoviesPresenter @Inject constructor(val useCase: MoviesUseCase<ThemoviedbList1>) : BasePresenter<MoviesFragmentCallBack,MovieDetailCallBack, MoviesCallBack>() {

    lateinit var themoviedbList1: ThemoviedbList1
    var results: List<Result> = arrayListOf()
    var movies: MutableList<Movie> = mutableListOf()


    fun loadMovies() {
        useCase.execute { it.either(::getError, ::addMoviesToMoviesList) }

    }

    fun addMoviesToMoviesList(themoviedbList1: ThemoviedbList1) {
        this.themoviedbList1 = themoviedbList1

        if(results.isNotEmpty()){
            results = arrayListOf()
        }

        results = themoviedbList1.results!!


        if(movies.isNotEmpty()){
            movies.clear()
        }

        for (result in results) {
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


        viewFragment.onCallBackMoviesFragment(movies)


    }

    fun getError(customError: CustomError) {

        val titleMessage = customError.errorMessage
        val errorMessage = customError.urlError

        viewActivity.onCallBackError(titleMessage, errorMessage)
    }

    fun getMovieDetail(movie: Movie){

        viewActivity.getDetailFragment()

//        viewFragmentDetail.onCallBackMovieDetail(movie)

    }

}