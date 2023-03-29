package uca.iut.clermont.model

import java.util.Calendar

class Season(
    val id: Int,
    val startDate: Calendar,
    val endDate: Calendar,
    val currentMatchday: Int,
    val winner: Int?
)