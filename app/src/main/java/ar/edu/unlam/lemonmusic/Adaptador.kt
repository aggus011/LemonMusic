package ar.edu.unlam.lemonmusic

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.elemento_lista.*
import kotlinx.android.synthetic.main.elemento_lista.view.*

class Adaptador (private var lista:ArrayList<Canciones>, private var contexto: Context): RecyclerView.Adapter<Adaptador.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.elemento_lista, parent, false), contexto)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }
    class ViewHolder(var vista:View, var contexto: Context): RecyclerView.ViewHolder(vista){
        fun bind(cancion: Canciones){
            vista.imagen.setImageResource(cancion.idImagen)
            vista.titulo.text = cancion.titulo

            vista.imagen.setOnClickListener {
                contexto.startActivity(Intent(contexto, Letra::class.java))
            }
            }
        }
    }