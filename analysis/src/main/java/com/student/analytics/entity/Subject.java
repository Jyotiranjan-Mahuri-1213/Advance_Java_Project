package com.student.analytics.entity;

public class Subject {

    private int id;
    private String subject_name;
    private String subject_code;
    private String course;
    private int semester;

    public Subject() {
    }

    public Subject(int id, String subject_name, String subject_code,
                   String course, int semester) {
        this.id = id;
        this.subject_name = subject_name;
        this.subject_code = subject_code;
        this.course = course;
        this.semester = semester;
    }

    public Subject(String subject_name, String subject_code,
                   String course, int semester) {
        this.subject_name = subject_name;
        this.subject_code = subject_code;
        this.course = course;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}