package uca.iut.clermont.model

import java.util.*
import java.util.concurrent.TimeUnit

class Contract(
    val start: Calendar,
    val until: Calendar
) {
    fun duration(): Int {
        val diffInMillis = until.timeInMillis - start.timeInMillis
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS).toInt()
    }
}