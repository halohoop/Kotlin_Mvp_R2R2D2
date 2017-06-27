package com.halohoop.kotlin_mvp_r2r2d2.ui.main

import com.halohoop.kotlin_mvp_r2r2d2.data.source.User
import com.halohoop.kotlin_mvp_r2r2d2.ui.IViews

/**
 * Created by Pooholah on 2017/6/27.
 */

/**
 * MainActivity V层接口
 */
interface IMainViews : IViews {

    fun showUsers(users: List<User>)
}