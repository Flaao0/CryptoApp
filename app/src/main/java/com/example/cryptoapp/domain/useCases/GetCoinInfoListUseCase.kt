package com.example.cryptoapp.domain.useCases

import com.example.cryptoapp.domain.repository.CoinRepository

class GetCoinInfoListUseCase(
    private val repository: CoinRepository
) {
    fun getCoinInfoList() = repository.getCoinInfoList()

}