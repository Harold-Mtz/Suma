package com.example.suma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.suma.ui.theme.SumaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SumaTheme {
            Suma()
            }
        }
    }
}

@Composable
fun Suma() {
    var valor1 by remember { mutableStateOf("") }
    var valor2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = valor1,
            onValueChange = { valor1 = it },
            label = { Text("Ingrese un número") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            value = valor2,
            onValueChange = { valor2 = it },
            label = { Text("Ingrese el número a sumar")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(10.dp))
20
        Button(
            onClick = {
                val num1 = valor1.toDoubleOrNull()
                val num2 = valor2.toDoubleOrNull()

                resultado = if (num1 != null && num2 != null) {
                    (num1 + num2).toString()
                } else {
                    "Entrada inválida"
                }
            }
        ) {
            Text("Sumar")
        }

        Spacer(Modifier.height(16.dp))

        Text("Resultado: $resultado")
    }
}