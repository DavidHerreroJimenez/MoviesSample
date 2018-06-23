package dherrero.moviessample.ui.base

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import dherrero.moviessample.MoviesApplication
import dherrero.moviessample.R.layout.baseactivity_layout
import dherrero.moviessample.di.ApplicationComponent
import dherrero.moviessample.ui.presenter.MoviesPresenter
import kotlinx.android.synthetic.main.baseactivity_layout.*
import kotlinx.android.synthetic.main.basetoolbar.*
import javax.inject.Inject
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.View.SYSTEM_UI_FLAG_VISIBLE
import android.widget.Toast
import dherrero.moviessample.ui.fragments.MovieDetail
import dherrero.moviessample.ui.fragments.MoviesFragment


/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui.base
 *
 * Created by dherrero on 12/06/18.
 */
abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MoviesPresenter

    private var savedInstanceState: Bundle? = Bundle()


    lateinit var myFragmentManager: FragmentManager



    val applicationComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {

        (application as MoviesApplication).appComponent
    }

    abstract fun addFragment(): BaseFragment



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(baseactivity_layout)
        setSupportActionBar(basetoolbar)


        this.savedInstanceState != savedInstanceState

        myFragmentManager = supportFragmentManager

        myFragmentManager.beginTransaction()
                .add(baseactivity_container.id, addFragment(), addFragment().javaClass.name)
                .addToBackStack(addFragment().javaClass.name)
                .commit()


        myFragmentManager.fragments
    }


    fun replacefragmentToFragment(newFragment: BaseFragment){

        myFragmentManager.beginTransaction()
                .replace(baseactivity_container.id, newFragment, newFragment.javaClass.name)
                .addToBackStack(newFragment.javaClass.name)
                .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        showStatusBar()

        if (myFragmentManager.fragments.isEmpty()) finish()

    }


    fun hideStatusBar(){

        val decorView = window.decorView
        decorView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
    }

    fun showStatusBar(){

        val decorView = window.decorView
        decorView.systemUiVisibility = SYSTEM_UI_FLAG_VISIBLE
    }


}