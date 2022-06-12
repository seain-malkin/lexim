package me.seain.lexim.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = Entry.name,
    foreignKeys = [
        ForeignKey(
            entity = Headword::class,
            parentColumns = [Headword.Columns.id],
            childColumns = [Entry.Columns.headwordId],
        ),
        ForeignKey(
            entity = Function::class,
            parentColumns = [Function.Columns.id],
            childColumns = [Entry.Columns.functionId],
        ),
        ForeignKey(
            entity = Pronunciation::class,
            parentColumns = [Pronunciation.Columns.id],
            childColumns = [Entry.Columns.pronunciationId],
        ),
    ],
)
data class Entry(
    @ColumnInfo(name = Columns.headwordId)
    val headwordId: Long,
    @ColumnInfo(name = Columns.functionId)
    val functionId: Long,
    @ColumnInfo(name = Columns.homograph)
    val homograph: Int = 0,
    @ColumnInfo(name = Columns.pronunciationId)
    val pronunciationId: Long? = null,
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
            const val pronunciationId = Pronunciation.foreignKey
            const val homograph = "homograph_number"
            const val offensive = "is_offensive"
        }
    }
}