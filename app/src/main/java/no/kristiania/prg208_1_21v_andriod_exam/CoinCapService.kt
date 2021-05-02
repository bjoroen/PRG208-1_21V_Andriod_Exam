package no.kristiania.prg208_1_21v_andriod_exam

import retrofit2.http.GET
import no.kristiania.prg208_1_21v_andriod_exam.model.CoinList
import retrofit2.Call

interface CoinCapService {



    @GET("/v2/assets")
    suspend fun getAllCoins(): Call<CoinList>


}

