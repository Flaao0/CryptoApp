package com.example.cryptoapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.repository.CoinRepositoryImpl
import com.example.cryptoapp.domain.useCases.GetCoinDetailsUseCase
import com.example.cryptoapp.domain.useCases.GetCoinInfoListUseCase
import com.example.cryptoapp.domain.useCases.LoadDataUseCase
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val getCoinDetailsUseCase = GetCoinDetailsUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase.getCoinInfoList()

    fun getDetailInfo(fSym: String) = getCoinDetailsUseCase.getCoinDetail(fSym)


    init {
        loadDataUseCase.loadData()
    }


}