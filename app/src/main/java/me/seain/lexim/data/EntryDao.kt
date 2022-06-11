package me.seain.lexim.data

import androidx.room.Dao
import androidx.sqlite.db.SimpleSQLiteQuery

@Dao
abstract class EntryDao : BaseDao<Entry>(Entry.name) {

    suspend fun findByHeadword(headwordId: Long) = getMany(SimpleSQLiteQuery(
            "SELECT * FROM ${Entry.name} WHERE ${Entry.Columns.headwordId} = $headwordId"
    ))
}