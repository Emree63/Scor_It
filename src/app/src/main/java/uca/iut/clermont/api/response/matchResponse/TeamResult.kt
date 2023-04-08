package uca.iut.clermont.api.response.matchResponse

import uca.iut.clermont.model.Area
import uca.iut.clermont.model.Coach
import uca.iut.clermont.model.Contract
import uca.iut.clermont.model.Team
import java.util.*

class TeamResult(
    val id: Int,
    val name: String,
    val shortName: String,
    val crest: String
) {
    fun toModel() = Team(
        id,
        name,
        shortName,
        crest,
        "",
        "",
        "",
        "",
        Area(1, "", "", "", ""),
        "",
        Coach(
            1, "", "", "", Calendar.getInstance()
                .apply { set(2022, 12, 28) }, "",
            Contract(
                Calendar.getInstance().apply { set(2020, 7, 1) },
                Calendar.getInstance().apply { set(2024, 7, 1) })
        ),
        listOf(),
        listOf()

    )
}