package com.example.cryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.cryptoapp.data.database.dao.AppDatabase
import com.example.cryptoapp.data.database.mapper.CoinMapper
import com.example.cryptoapp.domain.entities.CoinInfo
import com.example.cryptoapp.domain.repository.CoinRepository

class CoinRepositoryImpl(
    application: Application
): CoinRepository {

    private val coinInfoDao = AppDatabase.getInstance(
        application
    ).coinPriceInfoDao()

    private val mapper = CoinMapper()

    override fun getCoinInfoList(): LiveData<List<CoinInfo>> {
        TODO("Not yet implemented")
    }

    override fun getCoinDetails(fSym: String): LiveData<CoinInfo> {
        TODO("Not yet implemented")
    }
}