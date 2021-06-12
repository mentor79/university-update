package com.projects.university.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student extends Person {

    /*Ketu jane komentuar te gjitha variablat dhe getters and setters te tyre per arsye se klasa Student i trashegon
    te gjitha nga super klasa Person*/

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(name = "firstName")
//    private String firstName;
//
//    private String lastName;
//
//    private String address;

    private boolean isActive;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
