package dherrero.moviessample.domain.usecases


import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.errors.Either
import dherrero.moviessample.data.repository.MoviesRepositoryImpl
import dherrero.moviessample.data.rest.entities.ThemoviedbList1
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.domain
 *
 * Created by dherrero on 15/06/18.
 */
@Singleton
 class UseCase<out Type> @Inject constructor(val moviesRepositoryImpl: MoviesRepositoryImpl): BaseUseCase where Type : Any {


    fun execute(onResult: (Either<CustomError, ThemoviedbList1>) -> Unit) {
        val job = async(CommonPool) { moviesRepositoryImpl.getMovies() }
        launch(UI) { onResult.invoke(job.await()) }
    }
}

//    override
//    fun execute(onResult: (Either<CustomError, List<Movie>>) -> Unit, params: Params) {
////        val job = async(CommonPool) { moviesRepositoryImpl.run() }
////        launch(UI) { onResult.invoke(job.await()) }
//    }

