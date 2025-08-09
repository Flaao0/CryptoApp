package com.example.cryptoapp.domain.useCases

import com.example.cryptoapp.domain.repository.CoinRepository

class GetCoinDetailsUseCase(
    private val repository: CoinRepository,
) {

    fun getCoinDetail(fromSymbol: String)= repository.getCoinDetails(fromSymbol)


}