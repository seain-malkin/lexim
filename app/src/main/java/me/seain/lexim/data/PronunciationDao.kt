package me.seain.lexim.data

import androidx.room.Dao

@Dao
abstract class PronunciationDao : BaseDao<Pronunciation>(Pronunciation.name)