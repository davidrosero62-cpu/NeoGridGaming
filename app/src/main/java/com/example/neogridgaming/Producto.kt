package com.example.neogridgaming

data class Producto(
    val id_producto: Int,
    val nombre: String,
    val precio: Double,
    val stock: Int,
    val imagen: String?
) {
    val imagenUrl: String
        get() = "http://192.168.40.23:5000/static/img/productos/$imagen" // <--- Actualizado con la IP correcta de tu PC
}

