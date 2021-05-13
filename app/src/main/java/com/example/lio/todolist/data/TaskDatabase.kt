package com.example.lio.todolist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.lio.todolist.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase: RoomDatabase() {

    abstract fun taskDao(): TaskDao

    class Callback @Inject constructor(
        private val database: Provider<TaskDatabase>, //This way we inject an instance lazily when its called
       @ApplicationScope private val applicationScope: CoroutineScope
    ): RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().taskDao()
            applicationScope.launch {
                dao.insert(Task("Do homework"))
                dao.insert(Task("Do homework 2"))
                dao.insert(Task("Do homework 3", important = true))
                dao.insert(Task("Do homework 4"))
                dao.insert(Task("Do homework 5", completed = true))
                dao.insert(Task("Do homework 6", completed = true))
            }
        }
    }

}