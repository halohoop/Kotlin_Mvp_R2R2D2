package com.halohoop.kotlin_mvp_r2r2d2.ui.main

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.view.Gravity
import android.view.View
import android.view.animation.OvershootInterpolator
import com.bumptech.glide.Glide
import com.halohoop.kotlin_mvp_r2r2d2.AppComponent
import com.halohoop.kotlin_mvp_r2r2d2.BaseAct
import com.halohoop.kotlin_mvp_r2r2d2.R
import com.halohoop.kotlin_mvp_r2r2d2.data.source.User1
import com.halohoop.kotlin_mvp_r2r2d2.data.source.User2
import com.robinhood.ticker.TickerUtils
import kotlinx.android.synthetic.main.activity_main1.*
import org.jetbrains.anko.toast
import javax.inject.Inject


class Main1Activity : BaseAct(), IMain1Views, Main1Adapter.OnItemClickListener {

    override fun onItemClick(user: User1) {
//        println("User:" + user)
//        tv_compare.visibility = View.INVISIBLE
//        tickerView.visibility = View.INVISIBLE
//        ll_big.visibility = View.INVISIBLE
//        ll_small.visibility = View.INVISIBLE

        startLoading()

        //数据
        mainPresenter.getBigUser(user.name)

        val preferences = getSharedPreferences("self_data", Context.MODE_PRIVATE)
        val smallName = preferences.getString("self_name", "halohoop")
        mainPresenter.getSmallUser(smallName)
    }

    @Inject//有dagger2为我们注入对象，如果有inject又有modules的配置，modules优先
    lateinit var mainPresenter: Main1Presenter
    @Inject
    lateinit var mainAdapter: Main1Adapter

    override fun attachContentViewId(): Int {
        return R.layout.activity_main1
    }

    override fun initView() {
        //得益于apply plugin: 'kotlin-android-extensions'，所以直接从id就得到了实例，
        //比butterknife更好用
        main1RecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        main1RecyclerView.adapter = mainAdapter
        mainAdapter.onItemClick = this
        tv_compare.visibility = View.INVISIBLE
        tickerView.textColor = Color.CYAN
        tickerView.textSize = 90f
//        tickerView.setTypeface(myCustomTypeface);
        tickerView.animationDuration = 500
        tickerView.animationInterpolator = OvershootInterpolator()
        tickerView.gravity = Gravity.CENTER
        tickerView.setCharacterList(TickerUtils.getDefaultNumberList())
        tickerView.setText("000")
        tickerView.visibility = View.INVISIBLE

        ll_big.visibility = View.INVISIBLE
        ll_small.visibility = View.INVISIBLE
    }

    override fun initData() {
        //数据
        mainPresenter.getUsers()
        //
        val editor = getSharedPreferences("self_data", Context.MODE_PRIVATE).edit()
        editor.putString("self_name", "halohoop")
        editor.commit()
    }

    override fun showUsers(users: List<User1>) {
        stopLoading()
        mainAdapter.notifyDataSetChanged(users)
    }

    var showCount = 0;
    var bigUser: User2? = null;
    var smallUser: User2? = null;

    override fun showBigUser(user: User2) {
        if (user === null) {
            toast("大牛的数据获取失败")
            return
        }
        bigUser = user
        ll_big.visibility = View.VISIBLE
        Glide.with(this).load(user.avatar_url).into(user_avatar_big)
        user_name_big.text = user.name
        showCount++
        checkShowCount()
    }

    override fun showSmallUser(user: User2) {
        if (user === null) {
            toast("自己的数据获取失败")
            return
        }
        smallUser = user
        ll_small.visibility = View.VISIBLE
        user_name_small.text = user.name
        Glide.with(this).load(user.avatar_url).into(user_avatar_small)
        showCount++
        checkShowCount()
    }

    fun checkShowCount() {
        if (showCount >= 2) {
            tv_compare.visibility = View.VISIBLE
            tickerView.visibility = View.VISIBLE
            tv_compare.text = getString(R.string.compare_str)
            val bigFollowers = Integer.valueOf(bigUser?.followers)
            val smallFollowers = Integer.valueOf(smallUser?.followers)
            tickerView.setText("" + (bigFollowers - smallFollowers))
            showCount = 0
            stopLoading()
        }
    }

    /**
     * 初始化dagger2注入器
     */
    override fun setupAppComponent(appComponent: AppComponent) {
        DaggerMain1ActivityComponent
                .builder()
                .appComponent(appComponent)
                .main1ActivityModule(Main1ActivityModule(this))
                .build()./*绑定>>>*/inject(this)
    }
}
