package uca.iut.clermont.data

import android.content.Context
import androidx.room.*
import uca.iut.clermont.converters.Converters
import uca.iut.clermont.data.dao.CompetitionDao
import uca.iut.clermont.model.Competition

@Database(entities = arrayOf(Competition::class), version = 1)
@TypeConverters(Converters::class)
abstract class BDD : RoomDatabase() {

    abstract fun competitionDao(): CompetitionDao

    companion object {

        private var INSTANCE: BDD? = null

        fun getInstance(context: Context) =
            INSTANCE ?: synchronized(this) {
                val db = Room.databaseBuilder(
                    context,
                    BDD::class.java,
                    "ScorItDB"
                ).build()
                INSTANCE = db
                INSTANCE!!
            }

    }

}