package com.example.retvalorvesp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {

    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edtTextoAenviar = findViewById<EditText>(R.id.edAEnviar)
        var txtResposta = findViewById<TextView>(R.id.txtRetorno)
        var btnEnviar = findViewById<Button>(R.id.btEnviar)

        launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
                // manipulo os dados do meu retorno
                if (result.resultCode == RESULT_OK){
                    var data = result.data
                    txtResposta.text = data?.getStringExtra("digitado")
                }
        }

        btnEnviar.setOnClickListener(View.OnClickListener {

            var Tela2Intent = Intent(this, Tela2Activity::class.java)
            val str: String = edtTextoAenviar.text.toString()

            Tela2Intent.putExtra("digitado", str )
            launcher.launch(Tela2Intent)
        })



    }
}