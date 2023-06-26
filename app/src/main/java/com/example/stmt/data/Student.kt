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


) {
    // id 값을 가지지 않는 생성자
    constructor(
        studentName: String,
        tel: String,
        school: String,
        grade: String,
        gradeDetail: Int,
    ) : this(0, studentName, school, grade, gradeDetail, tel, 0)
}
