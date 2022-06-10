package me.seain.lexim.data

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery

abstract class BaseDao<E: BaseEntity>(
    private val tableName: String
) {
    suspend fun findById(id: Long): E? {
        return getOne(SimpleSQLiteQuery("SELECT * FROM $tableName WHERE id = $id"))
    }

    @Transaction
    open suspend fun upsert(e: E) {
        val rowId = insert(e)
        if (rowId == -1L) {
            update(e)
        } else {
            e.id = rowId
        }
    }

    @Transaction
    open suspend fun upsert(e: List<E>) {
        // Attempt to insert each entity.
        // Any insert failures are updated instead
        insert(e).mapIndexedNotNull { i, id ->
            when (id) {
                -1L -> e[i]
                else -> {
                    e[i].id = id
                    null
                }
            }
        }.let { if (it.isNotEmpty()) update(it) }
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insert(e: E): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insert(e: List<E>): List<Long>

    @Update(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun update(e: E): Int

    @Update(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun update(e: List<E>)

    @Delete
    abstract suspend fun delete(e: E)

    @Delete
    abstract suspend fun delete(e: List<E>)

    @RawQuery
    protected abstract suspend fun getOne(q: SupportSQLiteQuery): E?

    @RawQuery
    protected abstract suspend fun getMany(q: SupportSQLiteQuery): List<E>
}