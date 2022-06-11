package me.seain.lexim.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = SenseNode.name)
data class SenseNode(
    @ColumnInfo(name = Columns.entryId)
    val entryId: Long,
    @ColumnInfo(name = Columns.senseId)
    val senseId: Long? = null,
    @ColumnInfo(name = Columns.parentId)
    val parentId: Long? = null,
) : BaseEntity() {

    @ColumnInfo(name = Columns.id)
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0

    companion object {
        const val name = "sense_node"
        const val foreignKey = "sense_node_id"
    }

    class Columns {
        companion object {
            const val id = BaseEntity.Columns.id
            const val entryId = Entry.foreignKey
            const val senseId = Sense.foreignKey
            const val parentId = foreignKey
        }
    }
}