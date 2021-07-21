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
    private int employee_Id;
    private String first_Name;
    private String last_name;
    private int department_id;
    private String job_title;
    private Gender gender;
    private Timestamp date_of_birth;

}
