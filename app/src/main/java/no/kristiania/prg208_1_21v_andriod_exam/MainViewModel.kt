package no.kristiania.prg208_1_21v_andriod_exam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch
import no.kristiania.prg208_1_21v_andriod_exam.model.Coin
import no.kristiania.prg208_1_21v_andriod_exam.CoinCapService

class MainViewModel: ViewModel() {

    val coinCapService = API.coinCapService

    private val _firstCoin = MutableLiveData<Coin>()
    val firstCoin : LiveData<Coin> get() =_firstCoin


    val error = MutableLiveData<Boolean>()

    init {
     loadCoinCap()
    }

/*    fun loadCoinCap () {
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler{_,exception ->
            error.postValue(true)})
        {
            val coin = coinCapService.getAllCoins()
            _firstCoin.postValue(coin[0])
        }
    }*/

    fun loadCoinCap(){
        viewModelScope.launch(Dispatchers.IO){
            val coin = coinCapService.getAllCoins()
            _firstCoin.postValue(coin[0])
        }
    }


}

