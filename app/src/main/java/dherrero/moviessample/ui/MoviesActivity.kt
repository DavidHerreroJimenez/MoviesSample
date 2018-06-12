package dherrero.moviessample.ui

import dherrero.moviessample.ui.base.BaseActivity
import dherrero.moviessample.ui.base.BaseFragment

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui
 *
 * Created by dherrero on 12/06/18.
 */
class MoviesActivity: BaseActivity(){

    override fun addFragment(): BaseFragment = MoviesFragment().newInstance()
}