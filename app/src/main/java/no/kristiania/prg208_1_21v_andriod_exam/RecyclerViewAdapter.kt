package no.kristiania.prg208_1_21v_andriod_exam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import no.kristiania.prg208_1_21v_andriod_exam.databinding.CoinFragmentListBinding
import no.kristiania.prg208_1_21v_andriod_exam.model.Coin


class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var coinData = ArrayList<Coin>()

    fun setDataList(data: ArrayList<Coin>) {
        this.coinData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CoinFragmentListBinding.inflate(layoutInflater)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(coinData[position])
    }

    override fun getItemCount() = coinData.size

    class MyViewHolder(val binding: CoinFragmentListBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(data: Coin){
            binding.coin = data
            binding.executePendingBindings()
        }

    }




}