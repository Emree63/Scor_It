package uca.iut.clermont.api.response.competitionResponse

import uca.iut.clermont.model.Season
import java.text.SimpleDateFormat
import java.util.*

data class CurrentSeason(
    val currentMatchday: Int,
    val endDate: String,
    val id: Int,
    val startDate: String,
    val winner: Any
) {
    fun toModel(): Season {
        val calendar = Calendar.getInstance()
        val calendar2 = Calendar.getInstance()
        return Season(
            id,
            calendar.apply {
                time = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(startDate) as Date
            },
             calendar2.apply {
                time = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(endDate) as Date
            },
             currentMatchday,
             if (winner is Int) winner else null
        )
    }
}