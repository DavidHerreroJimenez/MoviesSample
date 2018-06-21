package dherrero.moviessample.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dherrero.moviessample.MoviesApplication
import dherrero.moviessample.di.ApplicationComponent
import dherrero.moviessample.ui.presenter.MoviesPresenter
import javax.inject.Inject

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui.base
 *
 * Created by dherrero on 12/06/18.
 */
abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var presenter: MoviesPresenter


    val applicationComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {

        (activity?.application as MoviesApplication).appComponent
    }

    abstract fun addFragmentLayout(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(addFragmentLayout(), container, false)


}