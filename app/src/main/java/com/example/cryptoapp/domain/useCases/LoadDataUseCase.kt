package com.example.cryptoapp.domain.useCases

import com.example.cryptoapp.domain.repository.CoinRepository

class LoadDataUseCase(
    private val repository: CoinRepository
) {

    fun loadData() {
        repository.loadData()
    }
}