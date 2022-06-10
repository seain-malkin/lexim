package me.seain.lexim.data

import androidx.room.Dao

@Dao
abstract class HeadwordDao : BaseDao<Headword>(Headword.name)