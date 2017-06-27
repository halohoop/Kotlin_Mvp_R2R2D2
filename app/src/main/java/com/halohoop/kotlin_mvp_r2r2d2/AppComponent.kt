package com.halohoop.kotlin_mvp_r2r2d2

import com.halohoop.kotlin_mvp_r2r2d2.data.DataManager
import com.halohoop.kotlin_mvp_r2r2d2.data.source.DataSourceModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Pooholah on 2017/6/27.
 * dagger2
 * 寻找由@inject注解表示的构造方法
 * 没找到就从@Component配置的
 * @inject和modules都配置了，那么优先使用modules配置的
 */

//作用域scope，生命周期，加了这个注解并不能帮我们实现单例，但是可以方便看代码，其他如果也有相同标识那么dagger2就认为相同周期
//所以一个是给自己看，一个还可以给dagger2看
@Singleton
//注入器标识，提供注入器，让dagger2为我们注入对象
//查找DataSourceModule中@Provides声明的方法
@Component(modules = arrayOf(DataSourceModule::class))
interface AppComponent {

    fun getDataManager(): DataManager

}
