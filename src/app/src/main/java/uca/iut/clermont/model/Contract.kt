package uca.iut.clermont.model

import java.util.*
import java.util.concurrent.TimeUnit

class Contract(
    val start: Date,
    val until: Date
) {
    fun duration(): Int {
        val diffInMillies = until.time - start.time
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS).toInt()
    }
}