package me.seain.lexim.data

import androidx.room.Dao
import androidx.sqlite.db.SimpleSQLiteQuery

@Dao
abstract class HeadwordDao : BaseDao<Headword>(Headword.name) {

    suspend fun findWord(word: String): Headword? {
        return getOne(SimpleSQLiteQuery(
            "SELECT * FROM ${Headword.name} WHERE ${Headword.Columns.word} = \"$word\""
        ))
    }
}