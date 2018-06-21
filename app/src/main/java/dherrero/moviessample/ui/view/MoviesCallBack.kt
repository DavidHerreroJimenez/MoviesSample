package dherrero.moviessample.ui.view

import dherrero.moviessample.ui.base.BaseCallBack

interface MoviesCallBack: BaseCallBack {

    fun onCallBackError(title: String, msg: String){}
}