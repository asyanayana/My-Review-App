package org.d3if1016.asessment2.network

import android.provider.ContactsContract
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" +
        "MuhammadZulfikar504/freeprofileapi/main/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ReviewService {
    @GET("profile.json")
    suspend fun getProfile(): List<Profile>
}

object ImageApi {
    val retrofitService : ReviewService by lazy {
        retrofit.create(ReviewService::class.java)
    }
}