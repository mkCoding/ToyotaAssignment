package com.example.toyataassignment.di

import com.example.toyataassignment.data.api.ApiDetails
import com.example.toyataassignment.data.api.ApiEndpoints
import com.example.toyataassignment.data.repository.ApiRepository
import com.example.toyataassignment.data.repository.ApiRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    //Create providers that will be injected throughout the app

    @Provides
    fun providesRetrofit(): Retrofit {
        //create okhttpClient
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor( HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY } )
            .build()

        //Retrofit Instance
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }

    @Provides
    fun providesApiEndpoints(retrofit: Retrofit): ApiEndpoints {
        return retrofit.create(ApiEndpoints::class.java)
    }

    @Provides
    fun providesRepository(apiEndpoints: ApiEndpoints): ApiRepository {
        return ApiRepositoryImpl(apiEndpoints)
    }

}