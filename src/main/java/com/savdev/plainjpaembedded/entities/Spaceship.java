package com.savdev.plainjpaembedded.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User: sav
 * Date: 19.12.14
 */
@Entity
public class Spaceship {

    @Id
    private long id;
    private String name;
    private int speed;

    public Spaceship() {
    }

    public Spaceship(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
