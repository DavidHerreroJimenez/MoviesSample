package dherrero.moviessample.ui.view

import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.ui.base.BaseCallBack

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui.view
 *
 * Created by dherrero on 23/06/18.
 */
interface MovieDetailCallBack: BaseCallBack{

    fun onCallBackMovieDetail(movie:Movie){

    }
}