package no.kristiania.prg208_1_21v_andriod_exam

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetroInstance {



    companion object {

        private val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        val BASE_URL = "https://api.coincap.io"

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .baseUrl(BASE_URL)
                    .build()
        }
    }
}