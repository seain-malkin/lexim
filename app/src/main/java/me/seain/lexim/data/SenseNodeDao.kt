package me.seain.lexim.data

import androidx.room.Dao

@Dao
abstract class SenseNodeDao : BaseDao<SenseNode>(SenseNode.name)