package com.codecool.stickman.GameObjects.Items;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Armor extends Item {

    private int healthIncrease;

    public Armor(String name, int value, int healthIncrease) {
        super(name, value);
        this.healthIncrease = healthIncrease;
    }

    public Armor() {
    }

    public int getHealthIncrease() {
        return healthIncrease;
    }
}
