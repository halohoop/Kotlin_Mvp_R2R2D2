package com.halohoop.kotlin_mvp_r2r2d2.ui.main

import com.halohoop.kotlin_mvp_r2r2d2.AppComponent
import com.halohoop.kotlin_mvp_r2r2d2.ui.ActivityScope
import dagger.Component

/**
 * Created by Pooholah on 2017/6/27.
 */

//注入器需要是抽象类或者接口
@ActivityScope//局部依赖与全局的注入器 dependencies
@Component(modules = arrayOf(Main1ActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface Main1ActivityComponent {

    /**
     * 提供一个方法注入，传入的参数就是要查找@Inject标签的类，方法名字无所谓，这里设置成inject
     * 为了精确指定一个对象的注入，而并不是全局便利查找所有有@Inject的类的属性
     * AppComponent没有这个方法是因为我们还不需要提供，
     */
    fun inject(main1Activity: Main1Activity)
}
