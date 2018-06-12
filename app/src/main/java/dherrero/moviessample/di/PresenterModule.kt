package dherrero.moviessample.di

import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dherrero.moviessample.ui.presenter.Presenter
import dherrero.moviessample.ui.presenter.PresenterImpl

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.di
 *
 * Created by dherrero on 12/06/18.
 */
@Module
abstract class PresenterModule{

    @Binds
    @IntoMap
    @ClassKey(PresenterImpl::class)
    internal abstract fun bindPresenterImpl(presenterImpl: PresenterImpl): Presenter

}