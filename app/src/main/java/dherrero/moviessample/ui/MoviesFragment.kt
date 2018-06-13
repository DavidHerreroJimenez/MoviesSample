package dherrero.moviessample.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import dherrero.moviessample.R.layout.movies_fragment
import dherrero.moviessample.ui.base.BaseFragment
import dherrero.moviessample.ui.presenter.PresenterImpl
import kotlinx.android.synthetic.main.movies_fragment.*
import javax.inject.Inject

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui
 *
 * Created by dherrero on 12/06/18.
 */
class MoviesFragment: BaseFragment(), View.OnClickListener{


    @Inject lateinit var presenterImpl: PresenterImpl



    override fun addFragmentLayout(): Int{
        return movies_fragment
    }


    fun newInstance(): MoviesFragment{

        val args = Bundle()

        val moviesFragment = MoviesFragment()

        moviesFragment.arguments = args

        return moviesFragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        buttonPulsame.setOnClickListener(this)

    }


    override fun onClick(p0: View?) {
        Toast.makeText(activity, "eeeeihhhh",Toast.LENGTH_LONG).show()

        presenterImpl = PresenterImpl()
        presenterImpl.loadMovies()
    }
}