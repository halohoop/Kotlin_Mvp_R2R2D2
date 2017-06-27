package com.halohoop.kotlin_mvp_r2r2d2.data.source.remote

import com.halohoop.kotlin_mvp_r2r2d2.data.source.IDataSource
import com.halohoop.kotlin_mvp_r2r2d2.data.source.User2
import com.halohoop.kotlin_mvp_r2r2d2.data.source.Users
import com.halohoop.kotlin_mvp_r2r2d2.data.source.Users1
import io.reactivex.Flowable

/**
 * Created by Pooholah on 2017/6/27.
 */

class LocalDataSource : IDataSource {

    override fun getUser(key: String): Flowable<Users> {
        return Flowable.just(Users(arrayListOf()))//模拟返回一个空的数据
    }

    override fun getUser1(): Flowable<Users1> {
        return Flowable.just(Users1(arrayListOf()))//模拟返回一个空的数据
    }

    override fun getUser2(id: String): Flowable<User2> {
        return Flowable.just(User2())//模拟返回一个空的数据
    }

}
