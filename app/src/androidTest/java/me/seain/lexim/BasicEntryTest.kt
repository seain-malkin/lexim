package me.seain.lexim

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import me.seain.lexim.data.AppDatabase
import me.seain.lexim.data.Headword
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class BasicEntryTest {
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext<Context>(),
            AppDatabase::class.java
        ).build()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeEntryAndReadList() {
        runBlocking {
            val word = "battle"
            val headword = Headword(word)
            db.headwordDao().insert(headword)
            val byWord = db.headwordDao().findByWord(word)
            assertThat(byWord, equalTo(headword))
        }
    }
}