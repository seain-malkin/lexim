package me.seain.lexim.data

import androidx.room.Dao

@Dao
abstract class SenseGroupDao : BaseDao<SenseGroup>(SenseGroup.name)