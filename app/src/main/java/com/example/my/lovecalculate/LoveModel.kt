package com.example.my.lovecalculate

import com.google.gson.annotations.SerializedName

data class LoveModel(

//{
//    "fname": "John",
//    "sname": "Alice",
//    "percentage": "46",
//    "result": "Can choose someone better."
//}

    @SerializedName("fname")
    val fname: String,
    @SerializedName("sname")
    val sname: String,
    val percentage: String,
    val result: String,

)
