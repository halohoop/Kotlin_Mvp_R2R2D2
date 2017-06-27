package com.halohoop.kotlin_mvp_r2r2d2.ui.main

import com.halohoop.kotlin_mvp_r2r2d2.data.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Pooholah on 2017/6/27.
 */
class MainPresenter(val iMainViews: IMainViews, val dataManager: DataManager) {
    fun getUsers(key: String) {
        dataManager.getUsers(key)
                .subscribeOn(Schedulers.io())//切换到io线程
                .observeOn(AndroidSchedulers.mainThread())//切换会主线程
                .doOnSubscribe { iMainViews.startLoading() }
                .doOnError { iMainViews.stopLoading() }
                .subscribe { iMainViews.showUsers(it) }//传递出去
    }
}
