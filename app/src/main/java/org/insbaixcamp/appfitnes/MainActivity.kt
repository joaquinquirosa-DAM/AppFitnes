package org.insbaixcamp.appfitnes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.insbaixcamp.appfitnes.ui.theme.AppFitnesTheme
import org.insbaixcamp.appfitnes.ui.theme.screen.EditProfileScreen
import org.insbaixcamp.appfitnes.ui.theme.screen.ProfileScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFitnesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        FitnessApp()
                    }
                }
            }
        }
    }
}

@Composable
fun FitnessApp() {
    var nom by remember { mutableStateOf("Laia Soler") }
    var email by remember { mutableStateOf("laia.soler@exemple.com") }
    var dataNaixement by remember { mutableLongStateOf(915148800000L) }
    var genere by remember { mutableStateOf("Dona") }
    var alçada by remember { mutableIntStateOf(170) }
    var pes by remember { mutableDoubleStateOf(60.0) }
    var pesObjectiu by remember { mutableDoubleStateOf(60.0) }
    var objectiu by remember { mutableStateOf("Guanyar massa muscular") }
    var nivellActivitat by remember { mutableStateOf("Moderat") }
    var editant by remember { mutableStateOf(false) }

    if (editant) {
        EditProfileScreen(
            nom = nom,
            email = email,
            dataNaixement = dataNaixement,
            genere = genere,
            alçada = alçada,
            pes = pes,
            pesObjectiu = pesObjectiu,
            objectiu = objectiu,
            nivellActivitat = nivellActivitat,
            onSave = { nomN, emailN, dataNaixementN, genereN, alçadaN, pesN, pesObjectiuN, objectiuN, nivellActivitatN ->
                nom = nomN
                email = emailN
                dataNaixement = dataNaixementN
                genere = genereN
                alçada = alçadaN
                pes = pesN
                pesObjectiu = pesObjectiuN
                objectiu = objectiuN
                nivellActivitat = nivellActivitatN
                editant = false
            }
        )
    } else {
        ProfileScreen(
            nom = nom,
            email = email,
            dataNaixement = dataNaixement,
            genere = genere,
            alçada = alçada,
            pes = pes,
            objectiu = objectiu,
            nivellActivitat = nivellActivitat,
            editar = { editant = true }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppFitnesTheme {
        FitnessApp()
    }
}
