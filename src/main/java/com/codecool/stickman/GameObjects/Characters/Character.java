package com.codecool.stickman.GameObjects.Characters;

import com.codecool.stickman.GameObjects.GameObject;
import com.codecool.stickman.GameObjects.GameObjectType;
import com.codecool.stickman.GameObjects.Items.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Character extends GameObject {
    protected int hitPoint;
    protected int damage;

    protected GameObjectType type;

    public Character(int X, int Y, int hitPoint, int damage) {
        super(X, Y);
        this.hitPoint = hitPoint;
        this.damage = damage;
    }

    protected Character() {
    }

    public void takeDamage(int damageAmount){
        this.hitPoint -= damageAmount;
    }

    public GameObjectType getType(){
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public int getHitPoint() {
        return hitPoint;
    }


    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

}
