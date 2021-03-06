package me.seain.lexim.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        Headword::class,
        Entry::class,
        Function::class,
        Label::class,
        Pronunciation::class,
    ],
    version = 2,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun headwordDao(): HeadwordDao
    abstract fun entryDao(): EntryDao
    abstract fun functionDao(): FunctionDao
    abstract fun labelDao(): LabelDao
    abstract fun pronunciationDao(): PronunciationDao

    companion object {
        private var DATABASE_NAME = "Lexim_Data"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}