package dherrero.moviessample.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import dherrero.moviessample.R.layout.movies_fragment
import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.ui.base.BaseFragment
import dherrero.moviessample.ui.view.MoviesFragmentCallBack
import kotlinx.android.synthetic.main.movies_fragment.*

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui
 *
 * Created by dherrero on 12/06/18.
 */
class MoviesFragment : BaseFragment(), View.OnClickListener, MoviesFragmentCallBack {


    var movies: MutableList<Movie> = mutableListOf()

    override fun addFragmentLayout(): Int {
        return movies_fragment
    }


    fun newInstance(): MoviesFragment {

        val args = Bundle()

        val moviesFragment = MoviesFragment()

        moviesFragment.arguments = args

        return moviesFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        applicationComponent.inject(this)

        presenter.viewFragment = this
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        buttonPulsame.setOnClickListener(this)

    }


    override fun onClick(p0: View?) {

        presenter.loadMovies()


    }


    override fun onCallBackMoviesFragment(newMovies: MutableList<Movie>) {

        movies.clear()

        movies.addAll(newMovies)

        Toast.makeText(context, movies.size.toString(), Toast.LENGTH_LONG).show()
    }

}