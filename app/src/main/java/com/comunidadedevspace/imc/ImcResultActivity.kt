package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ImcResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

     /*
     MENOR QUE 18,5       MAGREZA
     ENTRE 18,5 e 24,9    NORMAL
     ENTRE 25,0 E 29,9    SOBREPESO
     ENTRE 30,0 E 39,9    OBESIDADE
     MAIOR QUE 40,0       OBSESIDADE GRAVE
     */

        var classificacao = ""
        if (result <= 18.5f) {
            classificacao = "MAGREZA"
            tvClassificacao.setTextColor(Color.parseColor("#9d1108"))
        } else if(result > 18.5f && result <= 24.9f) {
            classificacao = "NORMAL"
            tvClassificacao.setTextColor(Color.parseColor("#26910d"))
        } else if(result >= 25.0f && result <= 29.9f) {
            classificacao = "SOBREPESO"
            tvClassificacao.setTextColor(Color.parseColor("#c99a08"))
        } else if(result >= 30.0f && result <= 39.9f) {
            classificacao = "OBESIDADE"
            tvClassificacao.setTextColor(Color.parseColor("#c99a08"))
        } else {
            classificacao = "OBESIDADE GRAVE"
            tvClassificacao.setTextColor(Color.parseColor("#9d1108"))
        }

        tvClassificacao.text = classificacao
    }
}
