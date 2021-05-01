package no.kristiania.prg208_1_21v_andriod_exam

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import no.kristiania.prg208_1_21v_andriod_exam.model.Coin
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl("https://api.coincap.io/v2/assets")
    .build()

object API {
    internal val coinCapService: CoinCapService by lazy {
        retrofit.create(CoinCapService::class.java)
    }
}