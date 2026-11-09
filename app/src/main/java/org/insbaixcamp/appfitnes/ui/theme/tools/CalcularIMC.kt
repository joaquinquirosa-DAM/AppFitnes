package org.insbaixcamp.appfitnes.ui.theme.tools

import kotlin.math.round

object CalcularIMC {
    /**
     * Calcula l'Índex de Massa Corporal (IMC) donat el pes en kg i l'alçada en cm.
     */
    fun calcularIMC(pesKg: Double, alcadaCm: Int): Double {
        if (alcadaCm <= 0) return 0.0
        val alcadaM = alcadaCm / 100.0
        val imc = pesKg / (alcadaM * alcadaM)
        return (imc * 10.0).let { round(it) / 10.0 }
    }
}
