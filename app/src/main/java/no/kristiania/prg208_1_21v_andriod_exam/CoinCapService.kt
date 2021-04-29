package no.kristiania.prg208_1_21v_andriod_exam

import no.kristiania.prg208_1_21v_andriod_exam.model.Coin
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinCapService {

    @GET("v2/assets")
    suspend fun getAllCoins(): List<Coin>

}