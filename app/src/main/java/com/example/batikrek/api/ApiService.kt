package com.example.batikrek.api

import com.example.batikrek.data.BatikRequest
import com.example.batikrek.data.BatikResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @POST("api/rekomendasi-batik/")
    suspend fun getBatikRecommendation(
        @Body request: BatikRequest
    ): BatikResponse
}