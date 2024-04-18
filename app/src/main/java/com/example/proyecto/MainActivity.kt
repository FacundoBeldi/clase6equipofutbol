package com.example.proyecto

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyView : RecyclerView
    private lateinit var adapter : Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyView = findViewById(R.id.recview)
        recyView.layoutManager = LinearLayoutManager(this)
        val dataSet = getListadoEquipos()
        adapter = Adapter(applicationContext)
        recyView.adapter = adapter
        adapter.submitList(dataSet)
        adapter.onItemClickListener = {
           val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("nombre", it.nombre)
            intent.putExtra("escudo", it.escudo)
            startActivity(intent)
        }
    }

    private fun getListadoEquipos(): MutableList<Equipo>? {
        return mutableListOf(
            Equipo(1, "River","Millonario","Mas Monumental","https://brandemia.org/contenido/subidas/2022/02/000-river-plate-1200x670.jpg",paises.Argentina),
            Equipo(2, "Boca","9del12","Bombonera","https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/CABJ70.png/1200px-CABJ70.png",paises.Argentina),
            Equipo(3, "Bayern Munich","Bayern","Allianz Arena","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/FC_Bayern_M%C3%BCnchen_logo_%282017%29.svg/1200px-FC_Bayern_M%C3%BCnchen_logo_%282017%29.svg.png",paises.Alemania),
            Equipo(4, "Borussia Dortmund","Borussia","Signal Iduna Park","https://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Borussia_Dortmund_logo.svg/800px-Borussia_Dortmund_logo.svg.png",paises.Alemania),
            Equipo(5, "Flamengo","Fla","Maracana","https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Flamengo_braz_logo.svg/1200px-Flamengo_braz_logo.svg.png",paises.Brasil),
            Equipo(6, "Gremio","Gremio","Arena do Gremio","https://upload.wikimedia.org/wikipedia/en/thumb/f/f1/Gremio.svg/1200px-Gremio.svg.png",paises.Brasil),
            Equipo(7, "Real Madrid","Merengues","Santiago Bernabeu","https://upload.wikimedia.org/wikipedia/en/thumb/5/56/Real_Madrid_CF.svg/1200px-Real_Madrid_CF.svg.png",paises.Espana),
            Equipo(8, "Barcelona","Cules","Camp Nou","https://a.espncdn.com/combiner/i?img=/i/teamlogos/soccer/500/83.png",paises.Espana),
            Equipo(9, "Chelsea","The Blues","Stamford Bridge","https://upload.wikimedia.org/wikipedia/en/thumb/c/cc/Chelsea_FC.svg/1200px-Chelsea_FC.svg.png",paises.Inglaterra),
            Equipo(10, "Manchester United","The Devils","Old Trafford","https://upload.wikimedia.org/wikipedia/en/thumb/7/7a/Manchester_United_FC_crest.svg/800px-Manchester_United_FC_crest.svg.png",paises.Inglaterra),
        )
    }
}