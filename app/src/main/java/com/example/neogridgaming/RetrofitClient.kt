package com.example.neogridgaming

import com.example.neogridtutorial.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Objeto Singleton para gestionar la instancia única de retrofit.
 * Este objeto se encarga de configurar la conexion con el servidor backend.
 */
object RetrofitClient {
    //Url base del backend desplegado en Render.
    //Todas las peticiones HTTP se realizarán relativas a esta dirección.
    private const val BASE_URL = "https://neo-grid-gaming-backend.onrender.com"

    /**
     * Configuramos un cliente HTTP personalizado (OkHttpClient) para aumentar el tiempo de espera (timeout).
     * Esto es vital para servidores en Render, ya que tardan unos segundos en "despertar" si están inactivos
     */
    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS) // Tiempo maximo para establecer la conexion
        .readTimeout(30, TimeUnit.SECONDS) // Tiempo maximo esperando la respuesta del servidor
        .writeTimeout(30, TimeUnit.SECONDS) // Tiempo maximo para enviar datos al servidor
        .build()
    /**
     * Instancia de ApiService configurada con Retrofit.
     * 'by lazy' asegura que la instancia se cree solo cuando sea llamada por primera vez (optimización de recursos)
     */

    val instance: ApiService by lazy {
        Retrofit.Builder()
        // Establece la dirección base del servidor
            .baseUrl(BASE_URL)
        // Utiliza Gson para convertir automáticamnete las respuestas JSON a objetos de Kotlin
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // Crea la implementación de la interfaz ApiService definida anteriormente
            .create(ApiService::class.java)
    }
}