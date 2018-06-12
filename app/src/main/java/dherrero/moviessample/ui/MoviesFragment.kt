package dherrero.moviessample.ui

import android.os.Bundle
import dherrero.moviessample.R.layout.movies_fragment
import dherrero.moviessample.ui.base.BaseFragment

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui
 *
 * Created by dherrero on 12/06/18.
 */
class MoviesFragment: BaseFragment(){

    override fun addFragmentLayout(): Int{
        return movies_fragment
    }


    fun newInstance(): MoviesFragment{

        val args = Bundle()

        val moviesFragment = MoviesFragment()

        moviesFragment.arguments = args

        return moviesFragment
    }
}