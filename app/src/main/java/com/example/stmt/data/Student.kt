package com.example.stmt.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int,

    var studentName: String,

    var school: String,

    var grade: String,

    var gradeDetail: Int,

    var tel: String,

    var classId: Long
)
