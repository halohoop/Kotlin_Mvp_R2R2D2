package com.halohoop.kotlin_mvp_r2r2d2.data.source

import io.reactivex.Flowable

/**
 * Created by Pooholah on 2017/6/27.
 */
interface IDataSource {
    fun getUser(key: String): Flowable<Users>
    fun getUser2(id: String): Flowable<User2>
    fun  getUser1(): Flowable<Users1>

}
