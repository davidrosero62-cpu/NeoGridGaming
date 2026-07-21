package com.example.neogridtutorial

import com.example.neogridgaming.Producto
import retrofit2.http.GET

interface ApiService {
    // Aquí definiremos las peticiones.
    // Por ahora, solo ponemos una función de ejemplo:
    @GET("api/productos")
    suspend fun getProductos(): List<Producto>
}