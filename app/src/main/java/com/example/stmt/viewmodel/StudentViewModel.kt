package com.example.stmt.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.stmt.data.StmtRepository
import com.example.stmt.data.StmtRoomDatabase
import com.example.stmt.data.student.Student
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

private const val TAG = "StudentViewModel_이현근"
class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val stmtRepository: StmtRepository

    private val _students = MutableStateFlow<List<Student>>(emptyList())
    val students: StateFlow<List<Student>> = _students.asStateFlow()

    init {
        val studentDao = StmtRoomDatabase.getInstance(application).studentDao()
        stmtRepository = StmtRepository(studentDao)
    }

    suspend fun addStudent(newStudent: Student) {
        stmtRepository.addStuent(newStudent)
    }
    fun getAllStudents() {
        viewModelScope.launch {
            stmtRepository.getAllStudents().collect { students ->
                Log.d(TAG, "getAllStudents: $students")
                _students.value = students
            }
        }
    }

    fun deleteStudent(student: Student) {
        viewModelScope.launch {
            stmtRepository.deleteStudent(student)
        }
    }
}