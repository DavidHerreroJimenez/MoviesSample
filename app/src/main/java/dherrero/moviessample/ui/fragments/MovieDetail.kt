package dherrero.moviessample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import dherrero.moviessample.R.layout.movie_detail
import dherrero.moviessample.data.base.Constants
import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.ui.base.BaseFragment
import dherrero.moviessample.ui.base.CropCircleTransformation
import dherrero.moviessample.ui.view.MovieDetailCallBack
import kotlinx.android.synthetic.main.movie_detail.*
import kotlinx.android.synthetic.main.movieslist_adapter.view.*

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui.fragments
 *
 * Created by dherrero on 22/06/18.
 */
class MovieDetail: BaseFragment(), MovieDetailCallBack {


    override fun addFragmentLayout(): Int {
        return movie_detail
    }

    fun newInstance(): MovieDetail {

        val args = Bundle()

        val movieDetail = MovieDetail()

        movieDetail.arguments = args

        return movieDetail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        applicationComponent.inject(this)

        presenter.viewFragmentDetail = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        posterImageDescription.setOnClickListener{presenter.getFullSizePoster()}
    }


    override fun onResume() {
        super.onResume()

        val movie = presenter.getDetails()


        titleDescription.text = movie.title
        originalTitleDescription.text = movie.originalTitle
        adultDescription.text = movie.adult.toString()
        mediaTypeDescription.text = movie.mediaType
        languageDescription.text = movie.language
        overviewDescription.text = movie.overview
        popularityDescription.text = movie.popularity.toString()


        releaseDateDescription.text = movie.releaseDate
        videoDescription.text = movie.video.toString()

        voteAverageDescription.rating = (movie.voteAverage.toFloat() /2)
        voteCountDescription.text = movie.voteCount.toString()


        Picasso.get()
                .load(Constants.BASE_URL_BACKDROP + movie.backDropImage)
                .into(backDropImageDescription)

        Picasso.get()
                .load(Constants.BASE_URL_BACKDROP + movie.posterImage)
                .into(posterImageDescription)



    }


}