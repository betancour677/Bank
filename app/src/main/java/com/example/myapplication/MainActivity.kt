package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var saldo: Double = 1000.0 // Saldo inicial de ejemplo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcomeTextView: TextView = findViewById(R.id.welcomeTextView)
        val checkBalanceButton: Button = findViewById(R.id.checkBalanceButton)
        val depositButton: Button = findViewById(R.id.depositButton)
        val withdrawButton: Button = findViewById(R.id.withdrawButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        checkBalanceButton.setOnClickListener {
            mostrarSaldo()
        }

        depositButton.setOnClickListener {
            depositarDinero(100.0) // Monto de ejemplo para depositar
        }

        withdrawButton.setOnClickListener {
            retirarDinero(200.0) // Monto de ejemplo para retirar
        }

        exitButton.setOnClickListener {
            finish()
        }
    }

    private fun mostrarSaldo() {
        val saldoTextView: TextView = findViewById(R.id.welcomeTextView)
        saldoTextView.text = "Saldo: $saldo"
    }

    private fun depositarDinero(monto: Double) {
        saldo += monto
        mostrarSaldo()
    }

    private fun retirarDinero(monto: Double) {
        if (monto <= saldo) {
            saldo -= monto
            mostrarSaldo()
        } else {
            mostrarMensaje("Saldo insuficiente para retirar.")
        }
    }

    private fun mostrarMensaje(mensaje: String) {
        val saldoTextView: TextView = findViewById(R.id.welcomeTextView)
        saldoTextView.text = mensaje
    }
}
