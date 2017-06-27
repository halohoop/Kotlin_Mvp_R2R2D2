package com.halohoop.kotlin_mvp_r2r2d2.api

import com.halohoop.kotlin_mvp_r2r2d2.data.source.User2
import com.halohoop.kotlin_mvp_r2r2d2.data.source.Users
import com.halohoop.kotlin_mvp_r2r2d2.data.source.Users1
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Pooholah on 2017/6/27.
 */

interface GithubService {

    /**
     * https://api.github.com/search/users?q=tom+repos:%3E42+followers:%3E1000
     */
    @GET("search/users") //配置请求URL，q为参数
    fun getUsers(@Query("q") key: String): Flowable<Users>

    /**
     * http://halohoop.com/2017
     */
    @GET("http://halohoop.com/halohoop_custom_datas/meals-kotlin_mvp_retrofit2_rxjava2_dagger2_demo/user1.json") //配置完整url
    fun getUsers1(): Flowable<Users1>

    /**
     * https://api.github.com/users/halohoop
     * https://api.github.com/users/{id}
     */
    @GET("users/{id}") //配置路径
    fun getUser2(@Path("id") id: String): Flowable<User2>

}