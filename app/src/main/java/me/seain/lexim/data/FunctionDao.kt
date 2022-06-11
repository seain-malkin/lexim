package me.seain.lexim.data

import androidx.room.Dao
import androidx.sqlite.db.SimpleSQLiteQuery

/**
 * A function represents a grammatical use, such as: noun, verb, adjective.
 */
@Dao
abstract class FunctionDao : BaseDao<Function>(Function.name) {

    /**
     * Finds a function based on its label.
     * @param label Label to search for
     * @return Corresponding entity or null
     */
    suspend fun findLabel(label: String): Function? {
        return getOne(SimpleSQLiteQuery(
            "SELECT * FROM ${Function.name} WHERE ${Function.Columns.label} = \"$label\"")
        )
    }
}