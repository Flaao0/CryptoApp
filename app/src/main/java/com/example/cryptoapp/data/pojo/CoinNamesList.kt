package com.example.cryptoapp.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinNamesList (
    @SerializedName("Data")
    @Expose
    val names: List<CoinNameContainer>? = null
)
