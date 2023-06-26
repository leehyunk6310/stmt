package com.example.stmt.data

class StmtRepository(private val studentDao: StudentDao) {

    fun addStuent(newStudent: Student) {
        studentDao.addStudent(newStudent)
    }

    fun updateStudent(newStudent: Student) {
        studentDao.updateStudent(newStudent)
    }
}