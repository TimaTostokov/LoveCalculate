package com.example.my.lovecalculate

import android.util.Log
import com.example.my.lovecalculate.model.LoveModel
import com.example.my.lovecalculate.model.RetrofitService
import com.example.my.lovecalculate.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter {

    private val api = RetrofitService().api
    private val TAG = "ololo"
    private lateinit var view: MainView

    fun getData(firstName: String, secondName: String) {
        api.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    val model = response.body()
                    model?.let {
                        App.appDatabase.getLoveDao().insert(it)
                        view.changeScreen(it)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun attachView(view: MainView) {
        this.view = view
    }

}