package dherrero.moviessample.model

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.model
 *
 * Created by dherrero on 13/06/18.
 */

data class MovieEntity(private val id){

    fun toMovie() = Movie(id)

}