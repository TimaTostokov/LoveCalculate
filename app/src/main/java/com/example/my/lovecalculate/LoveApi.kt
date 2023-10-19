package com.example.my.lovecalculate

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    //https://love-calculator.p.rapidapi.com/getPercentage?sname=Alice&fname=John
    //("X-RapidAPI-Key": 58bc6b32e9msha3e2ab9138998ebp1f55a3jsn207eb21cd775
    //("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")

    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = " 58bc6b32e9msha3e2ab9138998ebp1f55a3jsn207eb21cd775",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>

}