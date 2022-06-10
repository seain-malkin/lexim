package me.seain.lexim.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Label.name)
data class Label(
    @ColumnInfo(name = Columns.entryId)
    val entryId: Long,
    @ColumnInfo(name = Columns.general)
    val general: String,
    @ColumnInfo(name = Columns.subject)
    val subject: String,
) : BaseEntity() {

    @ColumnInfo(name = Columns.id)
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0

    companion object {
        const val name = "label"
    }

    class Columns {
        companion object {
            const val id = BaseEntity.Columns.id
            const val entryId = Entry.foreignKey
            const val general = "general"
            const val subject = "subject"
        }
    }
}