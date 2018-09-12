package com.codecool.stickman.GameObjects.Characters;
import com.codecool.stickman.GameObjects.GameObjectType;
import com.codecool.stickman.GameObjects.Items.*;

public class Player extends Character {
    private int strength;
    private int agility;
    private int intelligence;
    private Armor fullBody;
    private Weapon weapon;
    public static int X;
    public static int Y;



    public Player(int X, int Y) {
        super(X, Y, 30, 0);
        this.type = GameObjectType.PLAYER;
        strength = 3;
        agility = 3;
        intelligence = 3;
        this.X = X;
        this.Y = Y;
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


}
