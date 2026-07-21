package com.example.neogridgaming

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lanzamos la petición en segundo plano
        lifecycleScope.launch {
            try {
                // Llamamos a Retrofit para obtener los productos
                val respuesta = RetrofitClient.instance.getProductos()
                // Imprimimos la respuesta en el Logcat (la consola de Android Studio)
                Log.d("API_SUCCESS", "Productos recibidos: $respuesta")
            } catch (e: Exception) {
                // Si algo sale mal, aquí veremos el error
                Log.e("API_ERROR", "Error: ${e.message}")
            }
        }
    }
}