package no.kristiania.prg208_1_21v_andriod_exam.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import no.kristiania.prg208_1_21v_andriod_exam.R
import no.kristiania.prg208_1_21v_andriod_exam.databinding.CoinFragmentBinding

class ApiFragment: Fragment(R.layout.coin_fragment) {

    private lateinit var binding: CoinFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = CoinFragmentBinding.bind(view)

        ViewModel.firstCoin.observe(this) { apiResponse ->
            binding.fragmentCoinName.text = apiResponse.data[0].id
        }
    }

}