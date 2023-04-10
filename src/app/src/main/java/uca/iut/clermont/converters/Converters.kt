package uca.iut.clermont.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import uca.iut.clermont.model.Area
import uca.iut.clermont.model.Season

class Converters {

    @TypeConverter
    fun fromJson(json: String): Season {
        return Gson().fromJson(json, Season::class.java)
    }

    @TypeConverter
    fun toJson(season: Season): String {
        return Gson().toJson(season)
    }

    @TypeConverter
    fun fromJsonArea(json: String): Area {
        return Gson().fromJson(json, Area::class.java)
    }

    @TypeConverter
    fun toJson(area: Area): String {
        return Gson().toJson(area)
    }

}