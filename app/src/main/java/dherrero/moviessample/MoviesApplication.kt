package dherrero.moviessample

import android.app.Application
import dherrero.moviessample.di.ApplicationComponent
import dherrero.moviessample.di.ApplicationModule
import dherrero.moviessample.di.DaggerApplicationComponent

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample
 *
 * Created by dherrero on 12/06/18.
 */
class MoviesApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)


    }


}