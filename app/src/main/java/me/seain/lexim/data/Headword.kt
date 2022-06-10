package me.seain.lexim.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Headword.name)
data class Headword(
    @ColumnInfo(name = Columns.word) val word: String,
) : BaseEntity() {
    @ColumnInfo(name = Columns.id)
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0

    companion object {
        const val name = "headword"
        const val foreignKey = "headword_id"
    }

    class Columns {
        companion object {
            const val id = BaseEntity.Columns.id
            const val word = "word"
        }
    }
}