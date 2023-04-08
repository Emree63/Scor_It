package uca.iut.clermont.model

import uca.iut.clermont.api.response.playerResponse.CurrentTeamResponse
import java.text.SimpleDateFormat
import java.util.*

data class PlayerResponse(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val name: String,
    val dateOfBirth: String,
    val nationality: String,
    val position: String,
    val shirtNumber: Int,
    val lastUpdated: String,
    val currentTeam: CurrentTeamResponse
) {
    fun toModel() = Personne(
        id,
        firstName,
        lastName,
        name,
        Calendar.getInstance().apply {
            time = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(dateOfBirth)
        },
        nationality,
        Contract(
            Calendar.getInstance().apply {
                time = SimpleDateFormat("yyyy-MM", Locale.US).parse(currentTeam.contract.start)
            },
            Calendar.getInstance().apply {
                time = SimpleDateFormat("yyyy-MM", Locale.US).parse(currentTeam.contract.until)
            }
        )
    )

}
