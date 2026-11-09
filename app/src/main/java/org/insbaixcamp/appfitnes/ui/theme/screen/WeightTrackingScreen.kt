package org.insbaixcamp.appfitnes.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.insbaixcamp.appfitnes.ui.theme.AppFitnesTheme
import org.insbaixcamp.appfitnes.ui.theme.tools.CalcularIMC

@Composable
fun WeightTrackingScreen(
    pesActual: Double,
    pesObjectiu: Double,
    alçada: Int
) {
    val imc = CalcularIMC.calcularIMC(pesActual, alçada)

    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.padding(top = 16.dp)) {
            Card(
                Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Column(Modifier.padding(8.dp)) {
                    Text("Pes actual")
                    Text("$pesActual kg")
                }
            }
            Card(
                Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Column(Modifier.padding(8.dp)) {
                    Text("Pes objectiu")
                    Text("$pesObjectiu kg")
                }
            }
            Card(
                Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Column(Modifier.padding(8.dp)) {
                    Text("IMC")
                    Text(imc.toString())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WeightTrackingScreenPreview() {
    AppFitnesTheme {
        WeightTrackingScreen(
            pesActual = 75.0,
            pesObjectiu = 70.0,
            alçada = 175
        )
    }
}
