package com.example.stmt.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDao {
    @Insert
    fun addStudent(studentDto: Student)

    @Query("SELECT * FROM students WHERE id = :id")
    fun findStudentById(id: String): Student

    @Query("SELECT * FROM students")
    fun getAllStudents(): List<Student>

    @Update
    fun updateStudent(studentDto: Student)

    @Delete
    fun deleteStudent(studentDto: Student)
}