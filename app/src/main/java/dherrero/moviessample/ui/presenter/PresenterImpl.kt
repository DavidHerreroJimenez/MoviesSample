package dherrero.moviessample.ui.presenter

import dherrero.moviessample.data.repository.MoviesRepositoryImpl
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui.presenter
 *
 * Created by dherrero on 12/06/18.
 */
@Singleton
class PresenterImpl @Inject constructor(): Presenter{

    @Inject lateinit var moviesRepositoryImpl: MoviesRepositoryImpl

    fun loadMovies(){
        moviesRepositoryImpl.getMovies()
    }

}