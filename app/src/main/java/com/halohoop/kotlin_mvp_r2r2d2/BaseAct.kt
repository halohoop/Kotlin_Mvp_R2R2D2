package com.halohoop.kotlin_mvp_r2r2d2

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.indeterminateProgressDialog

/**
 * Created by Pooholah on 2017/6/27.
 */
abstract class BaseAct : AppCompatActivity() {

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(attachContentViewId())
        setupAppComponent(MyApp.getInstance().getAppComponent())
        initView()
        initData()
    }

    abstract fun attachContentViewId(): Int
    abstract fun initView()
    /**
     * call after initView
     */
    open fun initData() {}

    abstract fun setupAppComponent(appComponent: AppComponent)

    open fun startLoading() {
        if (progressDialog === null) {
            progressDialog = indeterminateProgressDialog ("正在加载..." )
//            progressDialog?.show()//不需要因为上面创建的时候就show
            progressDialog?.setCanceledOnTouchOutside(false)//让其不能点击外部消失
        } else {
            progressDialog?.show()
        }
    }

    open fun stopLoading() {
        progressDialog?.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        progressDialog?.dismiss()//just in case mem leak
    }
}