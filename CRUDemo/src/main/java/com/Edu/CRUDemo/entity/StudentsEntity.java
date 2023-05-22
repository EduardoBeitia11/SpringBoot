package com.Edu.CRUDemo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentsEntity {

    //Define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    public StudentsEntity(String firstName, String lastName, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

}
