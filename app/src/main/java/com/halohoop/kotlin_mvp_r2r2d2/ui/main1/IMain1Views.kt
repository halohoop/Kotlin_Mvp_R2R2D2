package com.halohoop.kotlin_mvp_r2r2d2.ui.main

import com.halohoop.kotlin_mvp_r2r2d2.data.source.User1
import com.halohoop.kotlin_mvp_r2r2d2.data.source.User2
import com.halohoop.kotlin_mvp_r2r2d2.ui.IViews

/**
 * Created by Pooholah on 2017/6/27.
 */

/**
 * Main1Activity V层接口
 */
interface IMain1Views : IViews {

    fun showUsers(users: List<User1>)
    fun showBigUser(user: User2)
    fun showSmallUser(user: User2)
}