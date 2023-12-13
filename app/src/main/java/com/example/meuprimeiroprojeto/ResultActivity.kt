package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /*// MENOR QUE18.5: ABAIXO DO PESO
        // ENTRE 18.6 e 24.9: NORMAL
        // ENTRE 25.0 e 29.0: SOBREPESO
        // ENTRE 30.0 e 34.9: OBESIDADE CLASSE I
        // ENTRE 35.0 e 39.9: OBESIDADE CLASSE II
        // MAIOR QUE 40.0: OBESIDADE CLASE III*/

        val classificacao = if (result < 18.5f) {
            "ABAIXO DO PESO"

        } else if (result in 18.6f..24.9f) {
            "NORMAL"

        } else if (result in 25.0f..29.0f) {
            "SOBREPESO"


        } else if (result in 30.0f..34.9f) {
            "OBESIDADE CLASSE I"


        } else if (result in 35.5f..39.9f) {
            "OBESIDADE CLASSE II"

        } else {
            "OBESIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}


