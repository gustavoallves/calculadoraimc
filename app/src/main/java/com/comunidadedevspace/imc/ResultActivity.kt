package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        val classificacao: String? = if (result <= 18.5f) {
            "MAGREZA"
        } else if (result <= 24.9f) {
            "NORMAL"
        } else if (result <= 29.9f) {
            "SOBREPESO"
        } else if (result <= 39.9f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }
        tvClassificacao.text = classificacao

        val btnback = findViewById<ImageButton>(R.id.btn_back)
        btnback.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}