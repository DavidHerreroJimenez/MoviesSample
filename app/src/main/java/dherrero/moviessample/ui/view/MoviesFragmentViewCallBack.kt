package dherrero.moviessample.ui.view

import dherrero.moviessample.domain.model.Movie

interface MoviesFragmentViewCallBack{

    fun onCallBackMoviesFragment(newMovies: MutableList<Movie>){}
}