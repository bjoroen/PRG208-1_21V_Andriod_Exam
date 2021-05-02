package no.kristiania.prg208_1_21v_andriod_exam

import android.icu.number.Precision.currency
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import no.kristiania.prg208_1_21v_andriod_exam.databinding.ActivityMainBinding
import no.kristiania.prg208_1_21v_andriod_exam.model.Coin
import no.kristiania.prg208_1_21v_andriod_exam.model.CoinList
import java.io.BufferedInputStream
import java.lang.reflect.Array.get
import java.net.HttpURLConnection
import java.net.URL
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

/*    val viewModel: MainViewModel by viewModels()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = makeApiCall()

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



    }
    private suspend fun makeApiCall(): MainViewModel{
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getCoinDataObserver().observe(this, Observer<CoinList>{
            if (it != null){
                viewModel.setAdapterData(it.CoinData as ArrayList<Coin>)
            } else{
                Toast.makeText(this@MainActivity, "Error in fetching data", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeApiCall();

        return viewModel
    }

}



