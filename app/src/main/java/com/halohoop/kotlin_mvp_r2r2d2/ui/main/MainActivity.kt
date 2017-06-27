package com.halohoop.kotlin_mvp_r2r2d2.ui.main

import android.support.v7.widget.LinearLayoutManager
import com.halohoop.kotlin_mvp_r2r2d2.AppComponent
import com.halohoop.kotlin_mvp_r2r2d2.BaseAct
import com.halohoop.kotlin_mvp_r2r2d2.R
import com.halohoop.kotlin_mvp_r2r2d2.data.source.User
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import javax.inject.Inject

class MainActivity : BaseAct(), IMainViews, MainAdapter.OnItemClickListener {

    override fun onItemClick(user: User) {
        println("User:"+user)
    }

    @Inject//有dagger2为我们注入对象，如果有inject又有modules的配置，modules优先
    lateinit var mainPresenter: MainPresenter
    @Inject
    lateinit var mainAdapter: MainAdapter

    override fun attachContentViewId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        //得益于apply plugin: 'kotlin-android-extensions'，所以直接从id就得到了实例，
        //比butterknife更好用
        mainRecyclerView.layoutManager = LinearLayoutManager(this)
        mainRecyclerView.adapter = mainAdapter
        mainAdapter.onItemClick = this
        mainSearch.onClick {
            val key = mainEdit.text.toString()
            mainPresenter.getUsers(key)
        }
    }

    override fun showUsers(users: List<User>) {
        stopLoading()
        mainAdapter.notifyDataSetChanged(users)
    }

    /**
     * 初始化dagger2注入器
     */
    override fun setupAppComponent(appComponent: AppComponent) {
        DaggerMainActivityComponent
                .builder()
                .appComponent(appComponent)
                .mainActivityModule(MainActivityModule(this))
                .build()./*绑定>>>*/inject(this)
    }
}
