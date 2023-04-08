package uca.iut.clermont.model

interface GenericDataManager<T> {
    suspend fun getItems(): List<T>
    suspend fun getItemById(id: Int): T?
}