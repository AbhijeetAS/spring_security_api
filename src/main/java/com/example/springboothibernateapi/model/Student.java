package com.example.springboothibernateapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @Column(name = "student_id" )
    private int StudentId;

    @Column(name = "student_name" )
    private String StudentName;

    @Column(name = "student_department" )
    private String StudentDepartment;

    @Column(name = "student_cgpa" )
    private int StudentCgpa;
}
