package com.example.stmt.data

import com.example.stmt.data.student.Student
import com.example.stmt.data.student.StudentDao
import kotlinx.coroutines.flow.Flow


class StmtRepository(private val studentDao: StudentDao) {

    suspend fun addStuent(newStudent: Student) {
        studentDao.addStudent(newStudent)
    }

    fun getAllStudents(): Flow<List<Student>> {
        return studentDao.getAllStudents()
    }

    suspend fun updateStudent(newStudent: Student) {
        studentDao.updateStudent(newStudent)
    }

    suspend fun deleteStudent(student: Student) {
        studentDao.deleteStudent(student)
    }
}