package com.example.calculadora_di

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraScreen()
        }
    }
}

@Composable
fun CalculadoraScreen() {
    var displayText by remember { mutableStateOf("0") }
    var numeroAnterior by remember { mutableStateOf("") }
    var operacion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Pantalla de resultados
        Text(
            text = displayText,
            fontSize = 60.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            textAlign = TextAlign.End
        )

        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(text = "+", modifier = Modifier.weight(1f)) {
                numeroAnterior = displayText
                operacion = "suma"
                displayText = "0"
            }
            CalculatorButton(text = "-", modifier = Modifier.weight(1f)) {
                numeroAnterior = displayText
                operacion = "resta"
                displayText = "0"
            }
            CalculatorButton(text = "x", modifier = Modifier.weight(1f)) {
                numeroAnterior = displayText
                operacion = "multiplicacion"
                displayText = "0"
            }
            CalculatorButton(text = "/", modifier = Modifier.weight(1f)) {
                numeroAnterior = displayText
                operacion = "division"
                displayText = "0"
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(text = "1", modifier = Modifier.weight(1f)) {
                displayText = if (displayText == "0") "1" else displayText + "1"
            }
            CalculatorButton(text = "2", modifier = Modifier.weight(1f)) {
                displayText = if (displayText == "0") "2" else displayText + "2"
            }
            CalculatorButton(text = "3", modifier = Modifier.weight(1f)) {
                displayText = if (displayText == "0") "3" else displayText + "3"
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(text = "4", modifier = Modifier.weight(1f)) {
                displayText = if (displayText == "0") "4" else displayText + "4"
            }
            CalculatorButton(text = "5", modifier = Modifier.weight(1f)) {
                displayText = if (displayText == "0") "5" else displayText + "5"
            }
            CalculatorButton(text = "6", modifier = Modifier.weight(1f)) {
                displayText = if (displayText == "0") "6" else displayText + "6"
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(text = "7", modifier = Modifier.weight(1f)) {
                displayText = if (displayText == "0") "7" else displayText + "7"
            }
            CalculatorButton(text = "8", modifier = Modifier.weight(1f)) {
                displayText = if (displayText == "0") "8" else displayText + "8"
            }
            CalculatorButton(text = "9", modifier = Modifier.weight(1f)) {
                displayText = if (displayText == "0") "9" else displayText + "9"
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(text = "=", modifier = Modifier.weight(1f)) {
                if (operacion == "suma") {
                    var resultado = numeroAnterior.toInt() + displayText.toInt()
                    displayText = resultado.toString()
                }
                if (operacion == "resta") {
                    var resultado = numeroAnterior.toInt() - displayText.toInt()
                    displayText = resultado.toString()
                }
                if (operacion == "multiplicacion") {
                    var resultado = numeroAnterior.toInt() * displayText.toInt()
                    displayText = resultado.toString()
                }
                if (operacion == "division" && displayText == "0") {
                    displayText = "No se puede dividir entre 0"
                }
                else if (operacion == "division") {
                    var resultado = numeroAnterior.toInt() / displayText.toInt()
                    displayText = resultado.toString()
                }


            }
            CalculatorButton(text = "0", modifier = Modifier.weight(1f)) {
                displayText = if (displayText == "0") "0" else displayText + "0"
            }
            CalculatorButton(text = "C", modifier = Modifier.weight(1f)) {
                displayText = "0"
            }
        }
    }
}

// Componente reutilizable que recibe el modifier como parámetro
@Composable
fun CalculatorButton(
    text: String,
    modifier: Modifier = Modifier, // <-- El modificador viene desde fuera
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(80.dp) // <-- Se lo aplicamos al botón aquí
    ) {
        Text(text = text, fontSize = 30.sp)
    }
}