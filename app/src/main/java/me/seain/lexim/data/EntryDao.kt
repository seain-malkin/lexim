package me.seain.lexim.data

import androidx.room.Dao

@Dao
abstract class EntryDao : BaseDao<Entry>(Entry.name)