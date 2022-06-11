package me.seain.lexim

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.runBlocking
import me.seain.lexim.data.AppDatabase
import me.seain.lexim.data.Entry
import me.seain.lexim.data.Function
import me.seain.lexim.data.Headword
import org.hamcrest.CoreMatchers
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
            ApplicationProvider.getApplicationContext(),
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
            val funcLabel = "noun"

            val headword = Headword(word)
            db.headwordDao().insert(headword)
            val headwordEntity = db.headwordDao().findWord(word)
            assertNotNull(headwordEntity)

            val function = Function(funcLabel)
            db.functionDao().insert(function)
            val functionEntity = db.functionDao().findLabel(funcLabel)
            assertNotNull(functionEntity)

            val entry1 = Entry(headwordEntity!!.id, functionEntity!!.id, 1)
            val entry2 = Entry(headwordEntity.id, functionEntity.id, 2)
            db.entryDao().insert(listOf(entry1, entry2))
            val entryEntities = db.entryDao().findByHeadword(headwordEntity.id)

            assertThat(headwordEntity, equalTo(headword))
            assertThat(functionEntity, equalTo(function))
            assertThat(entryEntities, CoreMatchers.hasItems(entry1, entry2))
        }
    }
}