package com.example.stmt.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.stmt.data.StmtRepository
import com.example.stmt.data.StmtRoomDatabase
import com.example.stmt.data.Student

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val stmtRepository: StmtRepository

    init {
        val studentDao = StmtRoomDatabase.getInstance(application).studentDao()
        stmtRepository = StmtRepository(studentDao)
    }

    suspend fun addStudent(newStudent: Student) {
        stmtRepository.addStuent(newStudent)
    }
}