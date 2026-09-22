package com.student.analytics.entity;

public class TeacherSubjectAssignment {

    private int id;
    private int teacher_id;
    private int subject_id;

    public TeacherSubjectAssignment() {
    }

    public TeacherSubjectAssignment(int id, int teacher_id, int subject_id) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.subject_id = subject_id;
    }

    public TeacherSubjectAssignment(int teacher_id, int subject_id) {
        this.teacher_id = teacher_id;
        this.subject_id = subject_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }
}