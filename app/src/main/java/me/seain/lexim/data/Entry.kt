package me.seain.lexim.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Entry.name)
data class Entry(
    @ColumnInfo(name = Columns.headwordId)
    val headwordId: Long,
    @ColumnInfo(name = Columns.functionId)
    val functionId: Long,
    @ColumnInfo(name = Columns.homograph)
    val homograph: Int = 0,
    @ColumnInfo(name = Columns.offensive)
    val offensive: Boolean = false,
) : BaseEntity() {
    @ColumnInfo(name = Columns.id)
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0

    companion object {
        const val name = "entry"
        const val foreignKey = "entry_id"
    }

    class Columns {
        companion object {
            const val id = BaseEntity.Columns.id
            const val headwordId = Headword.foreignKey
            const val functionId = Function.foreignKey
            const val homograph = "homograph_number"
            const val offensive = "is_offensive"
        }
    }
}