package com.halohoop.kotlin_mvp_r2r2d2.data

import com.halohoop.kotlin_mvp_r2r2d2.data.source.IDataSource
import com.halohoop.kotlin_mvp_r2r2d2.data.source.User
import com.halohoop.kotlin_mvp_r2r2d2.data.source.User1
import com.halohoop.kotlin_mvp_r2r2d2.data.source.User2
import io.reactivex.Flowable

/**
 * Created by Pooholah on 2017/6/27.
 * https://developer.github.com/
 * 从远程和从本地获取数据
 * 这个对象实例就是个单例的，我们可能需要在应用的任何地方用到
 * 所以我们可以使用dagger2注入这个对象
 * 关联到应用的application对象
 */
class DataManager(val remote: IDataSource, val local: IDataSource) {
    fun getUsers(key: String): Flowable<List<User>> {
        //onErrorResumeNext来自RxJava2，
        //远程拿不到从本地拿
        //最后使用Rxjava2操作符map，返回json数据中的集合参数
        return remote.getUser(key).onErrorResumeNext(local.getUser(key)).map { it.items }
    }

    fun getUsers1(): Flowable<List<User1>> {
        return remote.getUser1().onErrorResumeNext(local.getUser1()).map { it.items }
    }

    fun getUser2(name: String): Flowable<User2> {
        return remote.getUser2(name).onErrorResumeNext(local.getUser2(name)).map { it }
    }

}
