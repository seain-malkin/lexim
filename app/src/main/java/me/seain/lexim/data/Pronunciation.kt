package me.seain.lexim.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Pronunciation.name)
data class Pronunciation(
    @ColumnInfo(name = Columns.written)
    val written: String,
    @ColumnInfo(name = Columns.audio)
    val audio: String? = null,
    @ColumnInfo(name = Columns.preLabel)
    val preLabel: String? = null,
    @ColumnInfo(name = Columns.postLabel)
    val postLabel: String? = null,
    @ColumnInfo(name = Columns.separator)
    val separator: String? = null,
) : BaseEntity() {

    @ColumnInfo(name = Columns.id)
    @PrimaryKey(autoGenerate = true)
    override var id: Long = 0

    companion object {
        const val name = "pronunciation"
        const val foreignKey = "pronunciation_id"
    }

    class Columns {
        companion object {
            const val id = BaseEntity.Columns.id
            const val written = "written"
            const val audio = "audio"
            const val preLabel = "label_pre"
            const val postLabel = "label_post"
            const val separator = "separator"
        }
    }
}