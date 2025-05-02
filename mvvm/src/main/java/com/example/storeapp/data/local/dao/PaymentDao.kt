package com.example.storeapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import retrofit2.http.Query

@Dao
interface PaymentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<PaymentEntity>)

    @Query("SELECT * FROM payments WHERE userId = :userId ORDER BY date DESC")
    suspend fun getHistoryByUserId(userId: String): List<PaymentEntity>
}
