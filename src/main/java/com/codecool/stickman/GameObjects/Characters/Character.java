package com.codecool.stickman.GameObjects.Characters;

import com.codecool.stickman.GameObjects.GameObject;
import com.codecool.stickman.GameObjects.GameObjectType;
import com.codecool.stickman.GameObjects.Items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Character extends GameObject {
    protected int level;
    protected int hitPoint;
    protected int damage;
    protected int dodgeChanse;
    protected int armor;
    protected int hitChanse;



    List<Item> items = new ArrayList<>();
    protected GameObjectType type;

    public Character(int X, int Y, int hitPoint, int damage) {
        super(X, Y);
        this.hitPoint = hitPoint;
        this.damage = damage;
        this.dodgeChanse = 0;
        this.armor = 0;
        this.hitChanse = 100;
    }

    public void takeDamage(int damageAmount){
        Random dodge = new Random();
        if (dodge.nextInt(100)>this.dodgeChanse)
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

    public void addItemToInventory(Item item) {
        items.add(item);
    }

    public Item getItemById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst().orElse(null);
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public List<Item> getItems() {
        return items;
    }

}
