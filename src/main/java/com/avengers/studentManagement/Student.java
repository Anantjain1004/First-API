package com.avengers.studentManagement;

public class Student {
    private String name;
    private int age;
    private int adminNo;
    private String country;

    public Student(String name, int age, int adminNo, String country) {
        this.name = name;
        this.age = age;
        this.adminNo = adminNo;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
