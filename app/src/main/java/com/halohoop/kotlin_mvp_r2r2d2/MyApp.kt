package com.halohoop.kotlin_mvp_r2r2d2

import android.app.Application
import com.halohoop.kotlin_mvp_r2r2d2.data.source.DataSourceModule

/**
 * Created by Pooholah on 2017/6/27.
 */

class MyApp : Application() {

    lateinit private var appComponent: AppComponent;

    companion object {
        lateinit private var appInstance: MyApp
        fun getInstance(): MyApp {
            return appInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
        appComponent = DaggerAppComponent.builder().dataSourceModule(DataSourceModule()).build()
    }

    fun getAppComponent(): AppComponent = appComponent

}
