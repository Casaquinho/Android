package com.example.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var txtAltura = findViewById<EditText>(R.id.idAltura)
        var txtPeso = findViewById<EditText>(R.id.idPeso)
        var txtIMC = findViewById<TextView>(R.id.idIMC)
        var btnCalcular = findViewById<Button>(R.id.idBotaoIMC)


        fun calcular(peso : Double, Altura : Double){
            val imc: Double = peso / (Altura * Altura);
            if (imc < 18.5) {
                txtIMC.setText("IMC:  baixo... " + "\uD83D\uDD34")
            } else if (imc <= 24.9) {
                txtIMC.setText("IMC:  normal " + "\uD83D\uDFE2")
            } else if (imc <= 29.9) {
                txtIMC.setText("IMC:  alto... " + "\uD83D\uDFE1")
            } else if (imc <= 34.9) {
                txtIMC.setText("IMC:  Obesidade " + "\uD83D\uDD34")
            } else if (imc <= 40) {
                txtIMC.setText("IMC:  Obesidade extrema" + "\uD83D\uDD34")
            }
            else if(imc > 40)
            {
                txtIMC.setText("IMC:  Obesidade morbida" + "⚫")
            }
        }




        btnCalcular.setOnClickListener(View.OnClickListener {
            var editAltura = txtAltura.text.toString()
            val Altura = editAltura.toDouble()

            var editPeso = txtPeso.text.toString()
            var Peso = editPeso.toDouble()
            calcular(Peso, Altura)
        })
    }

}