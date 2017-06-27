package com.halohoop.kotlin_mvp_r2r2d2.data.source

import com.halohoop.kotlin_mvp_r2r2d2.api.GithubService
import com.halohoop.kotlin_mvp_r2r2d2.data.DataManager
import com.halohoop.kotlin_mvp_r2r2d2.data.source.local.Local
import com.halohoop.kotlin_mvp_r2r2d2.data.source.remote.LocalDataSource
import com.halohoop.kotlin_mvp_r2r2d2.data.source.remote.Remote
import com.halohoop.kotlin_mvp_r2r2d2.data.source.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Pooholah on 2017/6/27.
 */

@Module //优先级使用
class DataSourceModule {

    @Singleton
    @Provides //表示从这个方法来得到对象
    fun provideGithubService(): GithubService {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL).build().create(GithubService::class.java)
    }

    //有两个方法返回IDataSource，那么就需要qualified限定符来区分，
    //或者可以使用@Name的方式来指定

    @Singleton
    @Remote
    @Provides //表示从这个方法来得到对象
    fun provideRemote(service: GithubService): IDataSource {
        return RemoteDataSource(service)
    }

    @Singleton
    @Local
    @Provides //表示从这个方法来得到对象
    fun provideLocal(): IDataSource {
        return LocalDataSource()
    }

    @Singleton
    @Provides //表示从这个方法来得到对象
    fun provideDataManager(@Remote remote: IDataSource, @Local local: IDataSource): DataManager {
        return DataManager(remote, local)
    }
}
