package org.insbaixcamp.appfitnes.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.appfitnes.R
import org.insbaixcamp.appfitnes.ui.theme.components.CalendariPicker
import org.insbaixcamp.appfitnes.ui.theme.components.MenuDesplegable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixement: Long,
    genere: String,
    alçada: Int,
    pes: Double,
    pesObjectiu: Double,
    objectiu: String,
    nivellActivitat: String,
    onSave: (
        nom: String,
        email: String,
        dataNaixement: Long,
        genere: String,
        alçada: Int,
        pes: Double,
        pesObjectiu: Double,
        objectiu: String,
        nivellActivitat: String
    ) -> Unit
) {
    var nomNou by remember { mutableStateOf(nom) }
    var emailNou by remember { mutableStateOf(email) }
    var dataNaixementNou by remember { mutableStateOf(dataNaixement) }
    var genereNou by remember { mutableStateOf(genere) }
    var alçadaNouText by remember { mutableStateOf(alçada.toString()) }
    var pesNouText by remember { mutableStateOf(pes.toString()) }
    var pesObjectiuNouText by remember { mutableStateOf(pesObjectiu.toString()) }
    var objectiuNou by remember { mutableStateOf(objectiu) }
    var nivellActivitatNou by remember { mutableStateOf(nivellActivitat) }

    val opcionsGenere = listOf("Masculí", "Femení", "Altre", "Prefereixo no dir-ho")
    val opcionsObjectiu = listOf("Guanyar massa muscular", "Perdre pes", "Mantenir pes", "Millorar resistència")
    val opcionsNivellActivitat = listOf("Sedentari", "Lleuger", "Moderat", "Actiu", "Molt actiu")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Button(onClick = {}) { Text("Canviar foto") }
                Button(onClick = {}) { Text("Eliminar foto") }
            }
        }

        Text(
            text = "Dades personals",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        OutlinedTextField(
            value = nomNou,
            onValueChange = { nomNou = it },
            label = { Text("Nom complet") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        OutlinedTextField(
            value = emailNou,
            onValueChange = { emailNou = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        CalendariPicker(
            label = "Data de naixement",
            selectedDateMillis = dataNaixementNou,
            onDateSelected = { dataNaixementNou = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        MenuDesplegable(
            label = "Gènere",
            opcions = opcionsGenere,
            valorSeleccionat = genereNou,
            onValorSeleccionat = { genereNou = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        Text(
            text = "Dades físiques",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = alçadaNouText,
                onValueChange = { alçadaNouText = it },
                label = { Text("Alçada (cm)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = pesNouText,
                onValueChange = { pesNouText = it },
                label = { Text("Pes (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            OutlinedTextField(
                value = pesObjectiuNouText,
                onValueChange = { pesObjectiuNouText = it },
                label = { Text("Pes obj. (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }

        Text(
            text = "Objectius i activitat",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )

        MenuDesplegable(
            label = "Objectiu",
            opcions = opcionsObjectiu,
            valorSeleccionat = objectiuNou,
            onValorSeleccionat = { objectiuNou = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        MenuDesplegable(
            label = "Nivell d'activitat",
            opcions = opcionsNivellActivitat,
            valorSeleccionat = nivellActivitatNou,
            onValorSeleccionat = { nivellActivitatNou = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        Button(
            onClick = {
                val alçadaInt = alçadaNouText.toIntOrNull() ?: alçada
                val pesDouble = pesNouText.toDoubleOrNull() ?: pes
                val pesObjDouble = pesObjectiuNouText.toDoubleOrNull() ?: pesObjectiu

                onSave(
                    nomNou,
                    emailNou,
                    dataNaixementNou,
                    genereNou,
                    alçadaInt,
                    pesDouble,
                    pesObjDouble,
                    objectiuNou,
                    nivellActivitatNou
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Text("Guardar canvis")
        }
    }
}
