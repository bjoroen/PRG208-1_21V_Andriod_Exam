package no.kristiania.prg208_1_21v_andriod_exam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import no.kristiania.prg208_1_21v_andriod_exam.model.Coin
import no.kristiania.prg208_1_21v_andriod_exam.model.CoinList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivityViewModel: ViewModel() {

    /*val coinCapService = API.coinCapService*/

    lateinit var recyclerListData: MutableLiveData<CoinList>
    lateinit var recyclerViewAdapter: RecyclerViewAdapter


    //val error = MutableLiveData<Boolean>()

    init {
        recyclerListData = MutableLiveData()
        recyclerViewAdapter = RecyclerViewAdapter()
    }

    fun getAdapter(): RecyclerViewAdapter{
        return recyclerViewAdapter
    }

    fun setAdapterData(data : ArrayList<Coin>){
        recyclerViewAdapter.setDataList(data)
        recyclerViewAdapter.notifyDataSetChanged()
    }

    fun getCoinDataObserver(): MutableLiveData<CoinList>{
        return recyclerListData
    }

    suspend fun makeApiCall() {
        val retroInstance = RetroInstance.getRetroInstance().create(CoinCapService::class.java)
        val call = retroInstance.getAllCoins()
        call.enqueue(object : Callback<CoinList>{
            override fun onFailure(call: Call<CoinList>, t: Throwable) {
                recyclerListData.postValue(null)
            }

            override fun onResponse(call: Call<CoinList>, response: Response<CoinList>) {
                if(response.isSuccessful){
                    recyclerListData.postValue(response.body())
                }else{
                    recyclerListData.postValue(null)
                }
            }
        })
    }



    /*fun loadCoinCap () {
        viewModelScope.launch(Dispatchers.IO + CoroutineExceptionHandler{_,exception ->
            error.postValue(true)})
        {
            val coin = coinCapService.getAllCoins()
            _firstCoin.postValue(coin)
        }
    }*/


}

