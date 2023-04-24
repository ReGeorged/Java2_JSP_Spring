package com.exam.java_giorgi_bazierashvili.DAO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Student {
    private int id;

    public Student(String firstName, String lastName, String major, String address, String city) {
        FirstName = firstName;
        LastName = lastName;
        Major = major;
        Address = address;
        City = city;
    }

    private String FirstName;
    private String LastName;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Major='" + Major + '\'' +
                ", Address='" + Address + '\'' +
                ", City='" + City + '\'' +
                '}';
    }

    private String Major;
    private String Address;
    private String City;
}
