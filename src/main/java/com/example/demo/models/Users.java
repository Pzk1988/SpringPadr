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
    private String hash;

    @Override
    public String toString(){
        return "Id: " + userId + ", name: " + name + ", surname:" + surname + ", department: " + department
                + ", seed: " + seed + ", hash: " + hash;
    }
}
