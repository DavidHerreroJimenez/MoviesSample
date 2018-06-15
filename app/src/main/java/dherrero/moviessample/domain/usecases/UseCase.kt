package dherrero.moviessample.domain.usecases

import android.os.AsyncTask
import android.provider.Contacts
import android.support.compat.R.id.async
import dherrero.moviessample.data.errors.CustomError
import dherrero.moviessample.data.errors.Either
import dherrero.moviessample.data.rest.TheMoviedbApi
import dherrero.moviessample.domain.model.Movie
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.doAsync
import retrofit2.Response
import kotlinx.coroutines.experimental.async

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.domain
 *
 * Created by dherrero on 15/06/18.
 */

//abstract class UseCase<out Type, in Params>
//constructor(private val theMoviedbApi: TheMoviedbApi):
//        AsyncTask<Void, Void, Response<List<Movie>>>()
//        where Type:Any{
//
//    lateinit var responseResult: Response<List<Movie>>
//
//    override fun onPreExecute() {
//        super.onPreExecute()
//
//    }
//
//    override fun doInBackground(vararg p0: Void?): Response<List<Movie>> {
//
//        return theMoviedbApi.listMovies().execute()
//
//    }
//
//    override fun onPostExecute(result: Response<List<Movie>>) {
//        super.onPostExecute(result)
//
//        responseResult = result
//
//    }
//
//
//    fun getResultFromUseCaseTask(): Response<List<Movie>>{
//
//        return responseResult
//    }
//
//    class None
//
//}
abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<CustomError, Type>

    fun execute(onResult: (Either<CustomError, Type>) -> Unit, params: Params) {
        val job = async(CommonPool) { run(params) }
        launch(UI) { onResult.invoke(job.await()) }
    }

    class None
}