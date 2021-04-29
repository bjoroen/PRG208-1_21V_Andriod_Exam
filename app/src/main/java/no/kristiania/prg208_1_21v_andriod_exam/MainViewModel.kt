package no.kristiania.prg208_1_21v_andriod_exam

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import no.kristiania.prg208_1_21v_andriod_exam.model.Coin
import no.kristiania.prg208_1_21v_andriod_exam.CoinCapService

class MainViewModel: ViewModel() {

    val coinCapService = API.coinCapService

    val firstCoin = MutableLiveData<Coin>()

    init {
        viewModelScope.launch(Dispatchers.IO){
            val coin = coinCapService.getAllCoins()
            firstCoin.postValue(coin[0])
        }
    }
}