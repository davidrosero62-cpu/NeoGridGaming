package com.example.neogridgaming

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * Adaptador para gestionar y pintar la lista de productos en el RecyclerView.
 * Conecta los datos de la API con el diseño de las tarjetas (item_producto.xml).
 */
class ProductoAdapter(private val listaProductos: List<Producto>) :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    /**
     * ViewHolder encargado de mantener las referencias de los elementos visuales de cada tarjeta.
     */
    class ProductoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvNombreProducto)
        val tvPrecio: TextView = view.findViewById(R.id.tvPrecioProducto)
        val tvStock: TextView = view.findViewById(R.id.tvStock) // ID corregido según el XML
        val ivFoto: ImageView = view.findViewById(R.id.ivProducto)
    }

    /**
     * Infla el diseño visual de la tarjeta individual para cada producto.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_producto, parent, false)
        return ProductoViewHolder(view)
    }

    /**
     * Vincula los datos del producto actual con los componentes visuales de la tarjeta.
     */
    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = listaProductos[position]

        // Asignamos los textos correspondientes
        holder.tvNombre.text = producto.nombre
        holder.tvPrecio.text = "$ ${producto.precio}"
        holder.tvStock.text = "Stock: ${producto.stock}"

        // Cargamos la imagen desde Render utilizando Glide de manera eficiente
        Glide.with(holder.itemView.context)
            .load(producto.imagenUrl)
            .placeholder(android.R.drawable.ic_menu_gallery) // Imagen por defecto mientras carga
            .error(android.R.drawable.ic_dialog_alert) // Imagen en caso de error
            .centerCrop()
            .into(holder.ivFoto)
    }

    /**
     * Retorna el número total de elementos en la lista.
     */
    override fun getItemCount(): Int = listaProductos.size
}