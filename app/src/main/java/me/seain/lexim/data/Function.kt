package me.seain.lexim.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Function.name)
data class Function(
    @ColumnInfo(name = Columns.label) val label: String,
) : BaseEntity() {
    @ColumnInfo(name = Columns.id)
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0

    companion object {
        const val name = "function"
        const val foreignKey = "function_id"
    }

    class Columns {
        companion object {
            const val id = BaseEntity.Columns.id
            const val label = "label"
        }
    }
}