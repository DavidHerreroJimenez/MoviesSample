package dherrero.moviessample.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import dherrero.moviessample.R.layout.movies_fragment
import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.ui.base.BaseFragment
import dherrero.moviessample.ui.presenter.PresenterImpl
import dherrero.moviessample.ui.view.MoviesFragmentViewCallBack
import kotlinx.android.synthetic.main.movies_fragment.*
import javax.inject.Inject

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui
 *
 * Created by dherrero on 12/06/18.
 */
class MoviesFragment: BaseFragment(), View.OnClickListener, MoviesFragmentViewCallBack {


    @Inject lateinit var presenterImpl: PresenterImpl

    lateinit var movies:  MutableList<Movie>

    override fun addFragmentLayout(): Int{
        return movies_fragment
    }


    fun newInstance(): MoviesFragment{

        val args = Bundle()

        val moviesFragment = MoviesFragment()

        moviesFragment.arguments = args

        return moviesFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        applicationComponent.inject(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        buttonPulsame.setOnClickListener(this)

    }


    override fun onClick(p0: View?) {

        presenterImpl.loadMovies()


    }


//    override fun getMovies(movies:  MutableList<Movie>){
//
//        this.movies = movies
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Toast.makeText(activity,movies.size, Toast.LENGTH_LONG).show()
    }



    override fun onCallBackMoviesFragment(newMovies: MutableList<Movie>){

        this.movies = newMovies

        Toast.makeText(activity, movies.size, Toast.LENGTH_LONG).show()

    }

}