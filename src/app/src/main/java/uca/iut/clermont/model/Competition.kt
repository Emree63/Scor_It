package uca.iut.clermont.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "competitions")
class Competition(
    @PrimaryKey val id: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val code: String,
    @ColumnInfo val type: String,
    @ColumnInfo val emblem: String,
    val currentSeason: Season,
    val area: Area
)