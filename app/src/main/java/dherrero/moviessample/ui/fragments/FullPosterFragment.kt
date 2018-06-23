package dherrero.moviessample.ui.fragments

import android.os.Bundle
import com.squareup.picasso.Picasso
import dherrero.moviessample.R.layout.fullposter_fragment
import dherrero.moviessample.data.base.Constants
import dherrero.moviessample.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fullposter_fragment.*
import kotlinx.android.synthetic.main.movie_detail.*

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui.fragments
 *
 * Created by dherrero on 23/06/18.
 */
class FullPosterFragment: BaseFragment(){

    override fun addFragmentLayout(): Int = fullposter_fragment


    fun newInstance(): FullPosterFragment {

        val args = Bundle()

        val fragment = FullPosterFragment()

        fragment.arguments = args

        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        applicationComponent.inject(this)
    }


    override fun onResume() {
        super.onResume()

        Picasso.get()
                .load(Constants.BASE_URL_BACKDROP + presenter.movie.posterImage)
                .into(posterImage)
    }

}