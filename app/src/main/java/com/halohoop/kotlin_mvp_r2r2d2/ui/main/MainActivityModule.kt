package com.halohoop.kotlin_mvp_r2r2d2.ui.main

import com.halohoop.kotlin_mvp_r2r2d2.data.DataManager
import com.halohoop.kotlin_mvp_r2r2d2.ui.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by Pooholah on 2017/6/27.
 */
@Module
class MainActivityModule(val view: MainActivity) {

    @ActivityScope
    @Provides
    fun provideMainPresenter(dataManager: DataManager): MainPresenter {
        return MainPresenter(view, dataManager)
    }

    @ActivityScope
    @Provides
    fun provideMainAdapter(dataManager: DataManager): MainAdapter {
        return MainAdapter(view)
    }

}