package me.seain.lexim.data

import androidx.room.Dao

@Dao
abstract class LabelDao : BaseDao<Label>(Label.name)