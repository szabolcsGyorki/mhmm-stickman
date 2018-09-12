package com.codecool.stickman.GameObjects.Characters;
import com.codecool.stickman.GameObjects.GameObjectType;
import com.codecool.stickman.GameObjects.Items.*;
import com.sun.javafx.beans.IDProperty;
import org.eclipse.persistence.annotations.VariableOneToOne;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player extends Character {


    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    @ManyToOne
    private Armor fullBody;

    @ManyToOne
    private Weapon weapon;

    private int X;
    private int Y;

    @ManyToMany
    protected List<Item> items = new ArrayList<>();

    public Player(int X, int Y) {
        super(X, Y, 30, 0);
        this.type = GameObjectType.PLAYER;
        strength = 3;
        agility = 3;
        intelligence = 3;
        this.X = X;
        this.Y = Y;
        name = "Roger the don";
    }

    public Player() {
    }

    public void setFullBody(Armor fullBody) {
        if (this.fullBody != null)
            this.hitPoint -= this.fullBody.getHealthIncrease();
        this.hitPoint += fullBody.getHealthIncrease();
        this.fullBody = fullBody;
        this.setHitPoint(this.hitPoint + fullBody.getHealthIncrease());
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int attack(){
        if (this.weapon == null)
            return strength;
        return this.weapon.dealDamage() + strength;
    }

    public void changeStrength (int changeAmount){
        this.strength += changeAmount;
    }

    public boolean strengthTest(int testValue){
        return testValue<strength;
    }

    public void changeAgility (int changeAmount){
        this.agility += changeAmount;
    }

    public boolean agilityTest(int testValue){
        return testValue<agility;
    }

    public void changeIntelligence (int changeAmount){
        this.intelligence += changeAmount;
    }

    public boolean intelligenceTest(int testValue){
        return testValue<intelligence;
    }

    public String getName() {
        return name;
    }

    public void addItemToInventory(Item item) {
        items.add(item);
    }

    public Item getItemById(int id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst().orElse(null);
    }
}
