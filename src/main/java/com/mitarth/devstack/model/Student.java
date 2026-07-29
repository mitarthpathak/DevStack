package com.mitarth.devstack.model;

public class Student {
    private int id;
    private String name;

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
    private int marks;

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString(){
        return "Student{" +
                "id=" + id +
                ", name = ' " + name + '\'' +
                ", marks= " + marks +
                '}';
    }

    public Student(int id, String name, int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}
