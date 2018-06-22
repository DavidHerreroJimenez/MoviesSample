package dherrero.moviessample.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Adapter
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

    private lateinit var moviesList: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>


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

        presenter.loadMovies()



    }


    override fun onClick(p0: View?) {

        presenter.loadMovies()


    }


    override fun onCallBackMoviesFragment(newMovies: MutableList<Movie>) {

        movies.clear()

        movies.addAll(newMovies)

        viewAdapter = MoviesListAdapter(movies.toTypedArray())

        moviesList = moviesListRecyclerView as RecyclerView
        moviesList.setHasFixedSize(true)
        moviesList.layoutManager = LinearLayoutManager(context)
        moviesList.adapter = viewAdapter

//        viewAdapter.notifyDataSetChanged()

        Toast.makeText(context, movies.size.toString(), Toast.LENGTH_LONG).show()
    }

}