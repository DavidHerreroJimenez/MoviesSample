package dherrero.moviessample.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dherrero.moviessample.MoviesApplication
import dherrero.moviessample.R.layout.baseactivity_layout
import dherrero.moviessample.di.ApplicationComponent
import dherrero.moviessample.ui.presenter.MoviesPresenter
import kotlinx.android.synthetic.main.baseactivity_layout.*
import kotlinx.android.synthetic.main.basetoolbar.*
import javax.inject.Inject

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui.base
 *
 * Created by dherrero on 12/06/18.
 */
abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MoviesPresenter


    val applicationComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {

        (application as MoviesApplication).appComponent
    }

    abstract fun addFragment(): BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(baseactivity_layout)
        setSupportActionBar(basetoolbar)

        supportFragmentManager.beginTransaction().add(baseactivity_container.id, addFragment()).commit()
    }


    fun replacefragmentToFragment(newFragment: BaseFragment){

        supportFragmentManager.beginTransaction().replace(baseactivity_container.id, newFragment).commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        supportFragmentManager.popBackStack()
    }


}