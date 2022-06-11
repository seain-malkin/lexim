package me.seain.lexim.data

import androidx.room.Dao

@Dao
abstract class SenseDao : BaseDao<Sense>(Sense.name)