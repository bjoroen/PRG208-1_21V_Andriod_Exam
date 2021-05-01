package no.kristiania.prg208_1_21v_andriod_exam

import android.icu.number.Precision.currency
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import no.kristiania.prg208_1_21v_andriod_exam.databinding.ActivityMainBinding
import no.kristiania.prg208_1_21v_andriod_exam.model.Coin
import java.io.BufferedInputStream
import java.lang.reflect.Array.get
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.firstCoin.observe(this) { coin ->
            binding.mainScreenText.text = coin.id
            Glide.with(this).load(coin.symbol).into(binding.image)

        }


        viewModel.error.observe(this) { error ->
            if (error) {
                Snackbar.make(binding.root, "Some error occured. Check your internet connection", Snackbar.LENGTH_LONG).setAction("Refresh the page", { viewModel.loadCoinCap() }).show()
            }
        }

    }

}



