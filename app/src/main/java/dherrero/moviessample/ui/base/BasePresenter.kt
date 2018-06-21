package dherrero.moviessample.ui.base

abstract class BasePresenter<T : BaseCallBack, R : BaseCallBack> {

    lateinit var viewFragment: T

    lateinit var viewActivity: R
}