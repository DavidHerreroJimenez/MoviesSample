package dherrero.moviessample.ui.view

import dherrero.moviessample.ui.base.BaseCallBack

interface MoviesCallBack: BaseCallBack {

    fun onCallBackError(title: String, msg: String){}

    fun getDetailFragment()

    fun getFullPosterFragment()


    fun hideStatusBar()
}