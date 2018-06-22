package dherrero.moviessample.ui.fragments

import android.os.Bundle
import dherrero.moviessample.R.layout.movie_detail
import dherrero.moviessample.domain.model.Movie
import dherrero.moviessample.ui.base.BaseFragment
import dherrero.moviessample.ui.view.MovieDetailCallBack
import kotlinx.android.synthetic.main.movie_detail.*

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

    override fun onCallBackMovieDetail(movie: Movie) {
        super.onCallBackMovieDetail(movie)

//        backDropImageDescription
        titleDescription.text = movie.title
        originalTitleDescription.text = movie.originalTitle
        adultDescription.text = movie.adult.toString()
        mediaTypeDescription.text = movie.mediaType
        languageDescription.text = movie.language
        overviewDescription.text = movie.overview
        popularityDescription.text = movie.popularity.toString()

//        posterImageDescription

        releaseDateDescription.text = movie.releaseDate
        videoDescription.text = movie.video.toString()

        voteAverageDescription.text = movie.voteAverage.toString()
        voteCountDescription.text = movie.voteCount.toString()









    }
}