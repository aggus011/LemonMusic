package ar.edu.unlam.lemonmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cancion.*
import kotlinx.android.synthetic.main.activity_cancion.lemonimg
import kotlinx.android.synthetic.main.activity_letra.*
import kotlinx.android.synthetic.main.elemento_lista.*

class CancionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancion)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = Adaptador(generarDatosPrueba(), this)
        lemonimg.setOnClickListener {
            val intent4: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent4)
            finish()
        }

    }
        private fun generarDatosPrueba() : ArrayList<Canciones>{
            val lista=ArrayList<Canciones>()
            lista.add(Canciones(R.drawable.cancion, "Lemon"))
            lista.add(Canciones(R.drawable.cancion, "Lemon"))
            lista.add(Canciones(R.drawable.cancion, "Lemon"))
            lista.add(Canciones(R.drawable.cancion, "Lemon"))
            lista.add(Canciones(R.drawable.cancion, "Lemon"))
            return lista
        }
}