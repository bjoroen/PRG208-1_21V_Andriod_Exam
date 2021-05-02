package no.kristiania.prg208_1_21v_andriod_exam.model

import com.google.gson.annotations.Expose
import com.squareup.moshi.JsonClass


data class CoinList (
        val CoinData: List<Coin>,
        val timestamp: Long
        )

@JsonClass(generateAdapter = true)
data class Coin (
        val id: String,
        val rank: Int,
        val name: String,
        val symbol: String,
        val supply: String,
        val maxSupply: String?,
        val marketCapUsd: String,
        val volumeUsd24Hr: String,
        val priceUsd: String,
        val changePercent24Hr: String,
        val vwap24Hr: String?,
)

