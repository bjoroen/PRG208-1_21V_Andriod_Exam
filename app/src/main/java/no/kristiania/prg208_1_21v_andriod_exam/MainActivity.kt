package no.kristiania.prg208_1_21v_andriod_exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import no.kristiania.prg208_1_21v_andriod_exam.BR.viewModel
import no.kristiania.prg208_1_21v_andriod_exam.databinding.ActivityMainBinding
import no.kristiania.prg208_1_21v_andriod_exam.model.Coin
import no.kristiania.prg208_1_21v_andriod_exam.model.CoinList
import java.util.ArrayList



 class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

/*    val viewModel: MainViewModel by viewModels()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val viewModel = makeApiCall()

        setupBinding(viewModel)
    }


        /* binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)*/


        /*   viewModel.firstCoin.observe(this) { apiResponse ->
            binding.mainScreenText.text = apiResponse.data[0].id
            Glide.with(this).load(apiResponse.data[0].symbol).into(binding.image)

        }*/


/*
        viewModel.error.observe(this) { error ->
            if (error) {
                print(error.toString())
                Snackbar.make(binding.root, "Some error occured. Check your internet connection", Snackbar.LENGTH_LONG).setAction("Refresh the page", { viewModel.loadCoinCap() }).show()
            }
        }
*/


 fun setupBinding(viewModel: MainActivityViewModel) {
    val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    activityMainBinding.setVariable(BR.viewModel, viewModel)
    activityMainBinding.executePendingBindings()

    recyclerView.apply{

        layaoutManager =LinearLayoutManager(this@MainActivity)
        val decoration =DividerItemDecoration(this@MainActivity, VERTICAL)
        addItemDecoration(decoration)
    }


}



  suspend fun makeApiCall(): MainActivityViewModel{
        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.getCoinDataObserver().observe(this, Observer<CoinList>{

            if (it != null){
                viewModel.setAdapterData(it.CoinData as ArrayList<Coin>)
            } else{
                Toast.makeText(this@MainActivity, "Error in fetching data", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall()

        return viewModel
    }

}



