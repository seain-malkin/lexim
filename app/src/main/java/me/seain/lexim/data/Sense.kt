package me.seain.lexim.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Sense.name)
data class Sense(
    @ColumnInfo(name = Columns.label)
    val label: String,
    @ColumnInfo(name = Columns.text)
    val text: String,
    @ColumnInfo(name = Columns.joinWith)
    val joinWith: Long? = null,
) : BaseEntity() {

    @ColumnInfo(name = Columns.id)
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0

    companion object {
        const val name = "sense"
        const val foreignKey = "sense_id"
    }

    class Columns {
        companion object {
            const val id = BaseEntity.Columns.id
            const val label = "label"
            const val text = "text"
            const val joinWith = foreignKey
        }
    }
}