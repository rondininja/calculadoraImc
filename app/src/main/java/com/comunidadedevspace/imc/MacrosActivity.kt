package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText


class MacrosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_macros)

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso_macros)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura_macros)
        val edtIdade = findViewById<TextInputEditText>(R.id.edt_idade_macros)
        val spnAtividade = findViewById<Spinner>(R.id.spinner_atividade_fisica)
        val radioSexo = findViewById<RadioGroup>(R.id.radioGroup)

        val btnMacros = findViewById<Button>(R.id.btn_macros)


        btnMacros.setOnClickListener {

            val pesoStr: String = edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()
            val idadeStr: String = edtIdade.text.toString()
            val sexoRadio = radioSexo.checkedRadioButtonId
            val atividadeStr = spnAtividade.selectedItemId
            

                if (pesoStr == "" || alturaStr == "" || idadeStr == "" || sexoRadio == -1) {
                    Snackbar
                        .make(
                            edtPeso,
                            "Preencha todos os campos",
                            Snackbar.LENGTH_LONG
                        )
                        .show()
                } else {
                    val peso = pesoStr.toFloat()
                    val altura = alturaStr.toInt()
                    val idade = idadeStr.toInt()
                    var bee = 0.0
                    var gasto = 0.0
                    var naf = 0.0

                    when (sexoRadio) {
                        R.id.radio_masculino -> {
                            // BEE=88.36+(13.4×peso)+(4.8×altura)−(5.7×idade)
                            bee = 88.36 + (13.4 * peso) + (4.8 * altura) - (5.7 * idade)
                        }

                        R.id.radio_feminino -> {
                            // BEE=447.6+(9.25×peso)+(3.1×altura)−(4.3×idade)
                            bee = 447.6 + (9.25 * peso) + (3.1 * altura) - (4.3 * idade)
                        }
                    }

                    when (atividadeStr.toInt()) {
                        0 -> {
                            naf = 1.2
                        }

                        1 -> {
                            naf = 1.375
                        }

                        2 -> {
                            naf = 1.55
                        }

                        3 -> {
                            naf = 1.725
                        }

                        4 -> {
                            naf = 1.9
                        }
                    }

                    gasto = bee * naf

                    val intent = Intent(this, MacrosResultActivity::class.java)
                    intent.putExtra(KEY_RESULT_MACROS, gasto.toInt())
                    startActivity(intent)
                }
            }

            val spinnerAtividade: Spinner = findViewById(R.id.spinner_atividade_fisica)
            val itensAtividade = listOf(
                "Sedentário (Nenhuma atividade)",
                "Levemente ativo (1-2 dias/semana)",
                "Moderadamente ativo (3-5 dias/semana)",
                "Muito ativo (6-7 dias/semana)",
                "Atleta (2x por dia)"
            )

            val adapterAtividade =
                ArrayAdapter(this, android.R.layout.simple_spinner_item, itensAtividade)
            adapterAtividade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinnerAtividade.adapter = adapterAtividade

            spinnerAtividade.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    position: Int,
                    id: Long
                ) {
                    val selectedItem = itensAtividade[position]
                    Toast.makeText(this@MacrosActivity, "$selectedItem", Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        }
    }