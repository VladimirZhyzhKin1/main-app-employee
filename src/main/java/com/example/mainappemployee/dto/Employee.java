package com.example.mainappemployee.dto;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "job_title")
    private String jobTitle;

   // @Column(name = "gender")
    //private Gender gender;

    @Column(name = "date_of_birth")
    private Timestamp dateOfBirth;

}
