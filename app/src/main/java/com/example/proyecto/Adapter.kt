package com.example.proyecto
import android.content.Context
import android.media.audiofx.DynamicsProcessing.Eq
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter(val context: Context) : ListAdapter<Equipo, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Equipo) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val nombreEs: TextView = view.findViewById(R.id.item_nombre)
        val apodoEs: TextView = view.findViewById(R.id.item_apodo)
        val estadioEs: TextView = view.findViewById(R.id.item_estadio)
        val escudoEs: ImageView = view.findViewById(R.id.item_escudo)
        val paisesEs: ImageView = view.findViewById(R.id.item_pais)


        fun bind (equipo: Equipo) {
            nombreEs.text=equipo.nombre
            apodoEs.text=equipo.apodo
            estadioEs.text=equipo.estadio

            Glide.with(context).load(equipo.escudo).into(escudoEs)

            val image = when(equipo.pais) {
                paises.Alemania -> R.drawable.alemania
                paises.Argentina -> R.drawable.argentina
                paises.Brasil -> R.drawable.brasil
                paises.Espana -> R.drawable.espana
                else -> R.drawable.inglaterra
            }

            paisesEs.setImageResource(image)

            view.setOnClickListener() {
                onItemClickListener(equipo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val equipo = getItem(position)
        holder.bind(equipo)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Equipo>() {
        override fun areItemsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Equipo, newItem: Equipo): Boolean {
            return oldItem == newItem
        }
    }
}