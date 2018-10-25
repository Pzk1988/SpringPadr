package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "SIMPLETABLE")
public class Temperature implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int room;
    private float temperature;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getRoom() {
        return room;
    }
    public void setRoom(int room) {
        this.room = room;
    }

    public float getTemperature() {
        return temperature;
    }
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public Temperature(int room, float temperature)
    {
        this.room = room;
        this.temperature = temperature;
    }

    public Temperature()
    {
        
    }
}
