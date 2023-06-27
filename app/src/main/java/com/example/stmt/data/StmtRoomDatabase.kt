package com.example.stmt.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.stmt.data.lesson.Lesson
import com.example.stmt.data.lesson.LessonDao
import com.example.stmt.data.student.Student
import com.example.stmt.data.student.StudentDao

@Database(entities = [(Student::class)], version = 1)
abstract class StmtRoomDatabase :RoomDatabase(){
    abstract fun studentDao(): StudentDao
//    abstract fun lessonDao(): LessonDao
    companion object {
        /*The value of a volatile variable will never be cached, and all writes and reads will be done to and from the main memory.
        This helps make sure the value of INSTANCE is always up-to-date and the same for all execution threads.
        It means that changes made by one thread to INSTANCE are visible to all other threads immediately.*/
        @Volatile
        private var INSTANCE: StmtRoomDatabase? = null

        fun getInstance(context: Context): StmtRoomDatabase {
            // only one thread of execution at a time can enter this block of code
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        StmtRoomDatabase::class.java,
                        "stmt_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}