package com.comunidadedevspace.imc

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val KEY_RESULT_MACROS = "MacrosActivity.KEY_MACROS"

class MacrosResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_macros_result)

        val result = intent.getIntExtra(KEY_RESULT_MACROS, 0)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvEmagrecer = findViewById<TextView>(R.id.tv_emagrecer)
        val tvCrescer = findViewById<TextView>(R.id.tv_crescer)
        val tvSemanal = findViewById<TextView>(R.id.tv_semanal)


        tvResult.text = result.toString()
        tvEmagrecer.text = (result - 500).toString()
        tvCrescer.text = (result + 500).toString()
        tvSemanal.text = (result * 7).toString()
    }
}
