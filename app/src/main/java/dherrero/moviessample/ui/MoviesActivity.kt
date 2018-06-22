package dherrero.moviessample.ui

import android.os.Bundle
import android.support.v7.app.AlertDialog
import dherrero.moviessample.R
import dherrero.moviessample.ui.base.BaseActivity
import dherrero.moviessample.ui.base.BaseFragment
import dherrero.moviessample.ui.fragments.MovieDetail
import dherrero.moviessample.ui.fragments.MoviesFragment
import dherrero.moviessample.ui.view.MoviesCallBack

/**
 * Project name: MoviesSample
 * Package name: dherrero.moviessample.ui
 *
 * Created by dherrero on 12/06/18.
 */
class MoviesActivity : BaseActivity(), MoviesCallBack {

    override fun addFragment(): BaseFragment = MoviesFragment().newInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        applicationComponent.inject(this)

        presenter.viewActivity = this
    }


    override fun onCallBackError(title: String, msg: String) {

        val alertDialog = AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.btnAccept) { dialog, which ->
                    dialog.dismiss()
                }

        alertDialog.show()
    }


    override fun getDetailFragment() {
        super.getDetailFragment()

        super.replacefragmentToFragment(MovieDetail().newInstance())


    }
}