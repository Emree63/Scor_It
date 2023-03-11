package uca.iut.clermont.model

import java.util.Date

class season(
    val id: Int,
    val startDate: Date,
    val endDate: Date,
    val currentMatchday: Int,
    val winner: Int
) {
}