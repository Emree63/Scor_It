package uca.iut.clermont.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uca.iut.clermont.model.Competition

@Dao
interface CompetitionDao {

    @Delete
    fun deleteCompetition(competition: Competition)

    @Query("SELECT * FROM competitions")
    fun getAllCompetitions(): Flow<List<Competition>>

    @Insert
    fun insertCompetition(competition: Competition)

    @Query("SELECT * FROM competitions WHERE id=:id")
    fun getCompetitionById(id: Int): Flow<Competition?>

}