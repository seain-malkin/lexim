package me.seain.lexim.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.seain.lexim.data.AppDatabase
import me.seain.lexim.data.EntryDao
import me.seain.lexim.data.FunctionDao
import me.seain.lexim.data.HeadwordDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun provideHeadwordDao(appDatabase: AppDatabase): HeadwordDao {
        return appDatabase.headwordDao()
    }

    @Provides
    fun provideFunctionDao(appDatabase: AppDatabase): FunctionDao {
        return appDatabase.functionDao()
    }

    @Provides
    fun provideEntryDao(appDatabase: AppDatabase): EntryDao {
        return appDatabase.entryDao()
    }
}