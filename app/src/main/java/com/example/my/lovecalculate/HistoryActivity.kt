package com.example.my.lovecalculate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.my.lovecalculate.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = App.appDatabase.getLoveDao().getAll()

        list.forEach {
            binding.tvHistory.append(
                " \n ${it.fname}" +
                        " \n${it.fname} " +
                        "\n ${it.percentage} " +
                        "\n ${it.result} \n"
            )
        }
    }

}