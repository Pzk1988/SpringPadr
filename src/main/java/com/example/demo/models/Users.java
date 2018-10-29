package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "USERS")
public class Users implements Serializable{

    @Id
    @Column(name="user_id")
    private int userId;
    private String name;
    private String surname;
    private String department;
    private String seed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSeed() {
        return seed;
    }

    public void setSeed(String seed) {
        this.seed = seed;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    private String hash;

    @Override
    public String toString(){
        return "Id: " + userId + ", name: " + name + ", surname:" + surname + ", department: " + department
                + ", seed: " + seed + ", hash: " + hash;
    }
}
