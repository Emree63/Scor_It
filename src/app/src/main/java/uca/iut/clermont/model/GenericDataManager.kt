package uca.iut.clermont.model

interface GenericDataManager<T> {
    fun getItemsByName(substring: String): List<T>
    fun getItems(): List<T>
    fun getItemById(id: Int): T?
}