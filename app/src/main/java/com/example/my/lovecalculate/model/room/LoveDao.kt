package com.example.my.lovecalculate.model.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.my.lovecalculate.model.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @Query("SELECT * FROM love_table ORDER BY id DESC")
    fun getAll(): List<LoveModel>
}