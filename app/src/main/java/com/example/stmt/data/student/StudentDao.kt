package com.example.stmt.data.student

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {
    @Insert
    suspend fun addStudent(studentDto: Student)

    @Query("SELECT * FROM students WHERE id = :id")
    fun findStudentById(id: String): Student

    @Query("SELECT * FROM students")
    fun getAllStudents(): Flow<List<Student>>

    @Update
    fun updateStudent(studentDto: Student)

    @Delete
    suspend fun deleteStudent(studentDto: Student)
}