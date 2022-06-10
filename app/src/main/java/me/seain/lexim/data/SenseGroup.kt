package me.seain.lexim.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = SenseGroup.name)
data class SenseGroup(
    @ColumnInfo(name = Columns.entryId)
    val entryId: Long,
    @ColumnInfo(name = Columns.binding)
    val binding: Boolean
) : BaseEntity() {

    @ColumnInfo(name = Columns.id)
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0

    companion object {
        const val name = "sense_group"
        const val foreignKey = "sense_group_id"
    }

    class Columns {
        companion object {
            const val id = BaseEntity.Columns.id
            const val entryId = Entry.foreignKey
            const val binding = "binding"
        }
    }
}