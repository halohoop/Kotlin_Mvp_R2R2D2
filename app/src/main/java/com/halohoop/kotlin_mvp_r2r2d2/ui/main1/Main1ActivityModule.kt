package com.halohoop.kotlin_mvp_r2r2d2.ui.main

import com.halohoop.kotlin_mvp_r2r2d2.data.DataManager
import com.halohoop.kotlin_mvp_r2r2d2.ui.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by Pooholah on 2017/6/27.
 */
@Module
class Main1ActivityModule(val view: Main1Activity) {

    @ActivityScope
    @Provides
    fun provideMain1Presenter(dataManager: DataManager): Main1Presenter {
        return Main1Presenter(view, dataManager)
    }

    @ActivityScope
    @Provides
    fun provideMain1Adapter(dataManager: DataManager): Main1Adapter {
        return Main1Adapter(view)
    }

}