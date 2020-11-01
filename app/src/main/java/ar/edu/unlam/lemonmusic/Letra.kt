package ar.edu.unlam.lemonmusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_letra.*
import kotlinx.android.synthetic.main.activity_main.*

class Letra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_letra)
        lemonimg.setOnClickListener {
            val intent5: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent5)
            finish()
        }
    }
}