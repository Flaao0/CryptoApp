package com.example.cryptoapp.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "full_price_list")
data class CoinInfoDbModel(
    val type: String?,
    val market: String?,
    @PrimaryKey
    val fromSymbol: String,
    val toSymbol: String?,
    val flags: String?,
    val price: String?,
    val lastUpdate: Long?,
    val lastVolume: String?,
    val lastVolumeTo: String?,
    val lastTradeId: String?,
    val volumeDay: String?,
    val volumeDayTo: String?,
    val volume24Hour: String?,
    val volume24HourTo: String?,
    val openDay: String?,
    val highDay: String?,
    val lowDay: String?,
    val open24Hour: String?,
    val high24Hour: String?,
    val low24Hour: String?,
    val lastMarket: String?,
    val volumeHour: String?,
    val volumeHourTo: String?,
    val openHour: String?,
    val highHour: String?,
    val lowHour: String?,
    val topTierVolume24Hour: String?,
    val topTierVolume24HourTo: String?,
    val change24Hour: String?,
    val changePCT24Hour: String?,
    val changeDay: String?,
    val changePCTDay: String?,
    val supply: String?,
    val mktCap: String?,
    val totalVolume24Hour: String?,
    val totalVolume24HourTo: String?,
    val totalTopTierVolume24Hour: String?,
    val totalTopTierVolume24HourTo: String?,
    val imageUrl: String?
)
