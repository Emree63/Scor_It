package uca.iut.clermont.api.response.playerResponse

data class CurrentTeamResponse(
    val id: Int,
    val name: String,
    val contract: ContractResponse
)