package dherrero.moviessample.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dherrero.moviessample.MoviesApplication
import dherrero.moviessample.ui.MoviesActivity
import dherrero.moviessample.ui.MoviesFragment
import javax.inject.Singleton

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.di
 *
 * Created by dherrero on 12/06/18.
 */
@Singleton
@Component(modules = [ApplicationModule::class, PresenterModule::class])
interface ApplicationComponent{

    fun inject(moviesApplication: MoviesApplication)
    fun inject(moviesActivity: MoviesActivity)
    fun inject(moviesFragment: MoviesFragment)

}
