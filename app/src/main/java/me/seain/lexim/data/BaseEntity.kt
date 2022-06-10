package me.seain.lexim.data

abstract class BaseEntity {
    abstract var id: Long

    class Columns {
        companion object {
            const val id = "id"
        }
    }
}