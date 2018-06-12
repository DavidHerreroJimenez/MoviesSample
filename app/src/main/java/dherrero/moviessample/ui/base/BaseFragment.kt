package dherrero.moviessample.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dherrero.moviessample.di.ApplicationComponent

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui.base
 *
 * Created by dherrero on 12/06/18.
 */
abstract class BaseFragment: Fragment(){


    val applicationComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {

        applicationComponent
    }

    abstract fun addFragmentLayout(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(addFragmentLayout(), container, false)




}