package dherrero.moviessample.ui.view

import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.ui.base.BaseCallBack

interface MoviesFragmentCallBack: BaseCallBack {

    fun onCallBackMoviesFragment(newMovies: MutableList<Movie>) {}
}