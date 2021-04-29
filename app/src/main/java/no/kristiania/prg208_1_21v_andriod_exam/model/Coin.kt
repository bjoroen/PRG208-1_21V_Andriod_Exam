package no.kristiania.prg208_1_21v_andriod_exam.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coin (
    val id: String,
    val rank: Int,
    val symbol: String,
    val name: String,
    val changeLast24: String,
    val price: String,

)