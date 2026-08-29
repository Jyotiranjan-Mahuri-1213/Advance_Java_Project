package com.student.analytics.entity;

public class Student {

    private int id;
    private String name;
    private String email;
    private String regd_no;
    private String course;
    private int semester;

    public Student() {
    }

    public Student(String name, String email,
                   String regd_no,
                   String course,
                   int semester) {

        this.name = name;
        this.email = email;
        this.regd_no = regd_no;
        this.course = course;
        this.semester = semester;
    }

    public Student(int id, String name,
                   String email,
                   String rollNumber,
                   String course,
                   int semester) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.regd_no = regd_no;
        this.course = course;
        this.semester = semester;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegd_no() {
        return regd_no;
    }

    public void setRegd_no(String rollNumber) {
        this.regd_no = regd_no;
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