package com.example.cryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.cryptoapp.data.database.dao.AppDatabase
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.api.ApiFactory
import com.example.cryptoapp.domain.entities.CoinInfo
import com.example.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.delay

class CoinRepositoryImpl(
    application: Application,
) : CoinRepository {

    private val coinInfoDao = AppDatabase.getInstance(
        application
    ).coinPriceInfoDao()

    private val mapper = CoinMapper()
    private val apiService = ApiFactory.apiService

    override fun getCoinInfoList(): LiveData<List<CoinInfo>> {
        return coinInfoDao.getPriceList().map {
            it.map { coinInfoDbModel ->
                mapper.mapDbModelToEntity(coinInfoDbModel)
            }
        }
    }

    override fun getCoinDetails(fSym: String): LiveData<CoinInfo> {
        return coinInfoDao.getPriceInfoAboutCoin(fSym).map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadData() {
        while (true) {
            val topCoins = apiService.getTopCoinsInfo(limit = 50)
            val fromSymbols = mapper.mapNamesListToString(topCoins)
            val jsonContainer = apiService.getFullPriceList(fSyms = fromSymbols)
            val coinInfoDtoList = mapper.mapJsonContainerToListCoinInfo(jsonContainer)
            val dbModelList = coinInfoDtoList.map {
                mapper.mapDtoToDbModel(it)
            }
            coinInfoDao.insertPriceList(dbModelList)
            delay(10_000)
        }

    }
}