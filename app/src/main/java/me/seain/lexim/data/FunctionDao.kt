package me.seain.lexim.data

import androidx.room.Dao

@Dao
abstract class FunctionDao : BaseDao<Function>(Function.name)