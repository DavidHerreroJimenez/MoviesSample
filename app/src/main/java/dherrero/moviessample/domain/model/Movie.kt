package dherrero.moviessample.domain.model

import javax.inject.Inject

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.domain.model
 *
 * Created by dherrero on 12/06/18.
 */
data class Movie(
        val id: Int,
        val adult: Boolean,
        val backDropImage: String,
        val mediaType: String,
        val language: String,
        val originalTitle: String,
        val overview: String,
        val popularity: Double,
        val posterImage: String,
        val releaseDate:String,
        val title: String,
        val video: Boolean,
        val voteAverage: Double,
        val voteCount: Int
        )