package com.example.neogridgaming

/**
 * Modelo de datos que representa un producto de la tienda Neo Grid Gaming.
 * Contiene la informacion basica que devuelve el backend.
 */

data class Producto(
    val id_producto: Int,
    val nombre: String,
    val precio: Double,
    val stock:Int,
    val imagen: String?
) {
    /**
     * Propiedad calculada que genera la URL completa para descargar la imagen
     * del producto directamente desde el backend desplegado en render
     */
    val imagenUrl: String
        get() = "https://neo-grid-gaming-backend.onrender.com/static/img/productos/$imagen"
}