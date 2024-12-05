package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnImc = findViewById<Button>(R.id.btn_imc)
        val btnMacros = findViewById<Button>(R.id.btn_macros)

        btnImc.setOnClickListener {
            val intent = Intent(this, ImcActivity::class.java)
            startActivity(intent)
        }

        btnMacros.setOnClickListener {
            val intent = Intent(this, MacrosActivity::class.java)
            startActivity(intent)
        }
    }
}