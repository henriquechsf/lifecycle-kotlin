package com.example.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button

    var contador: Int = 0

    // cria a estrutura de todo o projeto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logar(valor = "onCreate")

        initDados()
        initContator()
        initClick()

        validaContador()
    }

    override fun onStart() {
        super.onStart()
        logar(valor = "onStart")
    }

    // layout renderizado
    override fun onResume() {
        super.onResume()
        logar(valor = "onResume")
    }

    override fun onPause() {
        logar(valor = "onPause")
        super.onPause()
    }

    override fun onStop() {
        logar(valor = "onPause")
        super.onStop()
    }

    override fun onDestroy() {
        logar(valor = "onDestroy")
        super.onDestroy()
    }

    private fun logar(tag: String = "Ciclo de Vida", valor: String) {
        Log.d(tag, valor)
    }

    private fun validaContador() {
        if(contador > 5) contador = 0
    }

    private fun initClick() {
        btnDados.setOnClickListener {
            contador++
            validaContador()
            initContator()
        }

        btnMostrar.setOnClickListener {
            Toast.makeText(this, "Valor Contador: ${contador.toString()}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initContator() {
        txtContador.setText(contador.toString())
    }

    private fun initDados() {
        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)
    }

}