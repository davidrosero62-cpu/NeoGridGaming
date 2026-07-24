package com.example.neogridgaming

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load

class ProductoAdapter(private val listaProductos: List<Producto>) :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvNombreProducto)
        val tvPrecio: TextView = view.findViewById(R.id.tvPrecioProducto)
        val tvStock: TextView = view.findViewById(R.id.tvProductotvStock) // <--- Agregado el stock aquí
        val ivFoto: ImageView = view.findViewById(R.id.ivProducto)       // <--- Corregido a 'ivFoto'
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = listaProductos[position]
        holder.tvNombre.text = producto.nombre
        holder.tvPrecio.text = "$ ${producto.precio}"
        holder.tvStock.text = "Stock: ${producto.stock}"

        // Cargando la imagen con Coil usando la URL completa
        holder.ivFoto.load(producto.imagenUrl) {
            crossfade(true)
            placeholder(android.R.drawable.ic_menu_gallery)
        }
    } // <--- Llave de cierre de onBindViewHolder que faltaba

    override fun getItemCount(): Int = listaProductos.size
}