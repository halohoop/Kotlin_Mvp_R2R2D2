package com.halohoop.kotlin_mvp_r2r2d2.ui.main

import com.halohoop.kotlin_mvp_r2r2d2.data.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Pooholah on 2017/6/27.
 */
class Main1Presenter(val iMainViews: IMain1Views, val dataManager: DataManager) {
    fun getUsers() {
        dataManager.getUsers1()
                .subscribeOn(Schedulers.io())//切换到io线程
                .observeOn(AndroidSchedulers.mainThread())//切换会主线程
                .doOnSubscribe { iMainViews.startLoading() }
                .doOnError { iMainViews.stopLoading() }
                .subscribe { iMainViews.showUsers(it) }//传递出去
    }

    fun getBigUser(name: String) {
        dataManager.getUser2(name)
                .subscribeOn(Schedulers.io())//切换到io线程
                .observeOn(AndroidSchedulers.mainThread())//切换会主线程
                .doOnSubscribe { iMainViews.startLoading() }
                .doOnError { iMainViews.stopLoading() }
                .subscribe { iMainViews.showBigUser(it) }//传递出去
    }

    fun getSmallUser(name: String) {
        dataManager.getUser2(name)
                .subscribeOn(Schedulers.io())//切换到io线程
                .observeOn(AndroidSchedulers.mainThread())//切换会主线程
                .doOnSubscribe { iMainViews.startLoading() }
                .doOnError { iMainViews.stopLoading() }
                .subscribe { iMainViews.showSmallUser(it) }//传递出去
    }
}
