package uca.iut.clermont.application

import android.app.Application
import uca.iut.clermont.data.BDD

class ScorItApplication: Application() {

    val db: BDD by lazy { BDD.getInstance(this) }

}