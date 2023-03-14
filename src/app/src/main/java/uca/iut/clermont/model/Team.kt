package uca.iut.clermont.model

class Team(
    val id: Int,
    val name: String,
    val shortName: String,
    val crest: String,
    val address: String,
    val website: String,
    val founded: String,
    val clubColors: String,
    val area: Area,
    val venue: String,
    val coach: Coach,
    val staff: List<Staff>,
    val squads: List<Player>
)