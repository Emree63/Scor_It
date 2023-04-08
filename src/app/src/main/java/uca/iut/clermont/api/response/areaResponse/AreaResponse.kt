package uca.iut.clermont.api.response.areaResponse

import uca.iut.clermont.model.Area

data class AreaResponse(
    val areas: List<Area>,
    val count: Int
)