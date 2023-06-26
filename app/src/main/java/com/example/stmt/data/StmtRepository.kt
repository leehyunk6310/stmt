package com.example.stmt.data

class StmtRepository(private val studentDao: StudentDao) {

    suspend fun addStuent(newStudent: Student) {
        studentDao.addStudent(newStudent)
    }

    suspend fun updateStudent(newStudent: Student) {
        studentDao.updateStudent(newStudent)
    }
}