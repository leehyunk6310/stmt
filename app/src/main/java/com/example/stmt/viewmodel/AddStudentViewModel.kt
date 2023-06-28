package com.example.stmt.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class AddStudentViewModel(): ViewModel() {
    // <editor-fold desc = "등록할 때 필요한 데이터"
    private val _name = MutableStateFlow("")
    private val _tel = MutableStateFlow("")
    private val _school = MutableStateFlow("")
    private val _grade = MutableStateFlow("")
    private val _gradeDetail = MutableStateFlow(0)

    val name
        get() = _name
    fun setName(newName: String) {
        _name.value = newName
    }

    val tel
        get() = _tel
    fun setTel(newPhone: String) {
        _tel.value = newPhone
    }

    val school
        get() = _school
    fun setSchool(newSchool: String) {
        _school.value = newSchool
    }

    val grade
        get() = _grade
    fun setGrade(newGrade: String) {
        _grade.value = newGrade
    }

    val gradeDetail
        get() = _gradeDetail
    fun setGradeDetail(newGradeDetail: Int) {
        _gradeDetail.value = newGradeDetail
    }
    // </editor-fold>

}