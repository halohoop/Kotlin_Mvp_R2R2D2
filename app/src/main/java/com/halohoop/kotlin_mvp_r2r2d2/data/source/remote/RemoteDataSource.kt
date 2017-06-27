package com.halohoop.kotlin_mvp_r2r2d2.data.source.remote

import com.halohoop.kotlin_mvp_r2r2d2.api.GithubService
import com.halohoop.kotlin_mvp_r2r2d2.data.source.IDataSource
import com.halohoop.kotlin_mvp_r2r2d2.data.source.User2
import com.halohoop.kotlin_mvp_r2r2d2.data.source.Users
import com.halohoop.kotlin_mvp_r2r2d2.data.source.Users1
import io.reactivex.Flowable

/**
 * Created by Pooholah on 2017/6/27.
 */

class RemoteDataSource(val service: GithubService) : IDataSource {
    override fun getUser2(id: String): Flowable<User2> = service.getUser2(id)

    override fun getUser1(): Flowable<Users1> = service.getUsers1()

    //使用retrofit2获取远程数据
    override fun getUser(key: String): Flowable<Users> = service.getUsers(key)

}
