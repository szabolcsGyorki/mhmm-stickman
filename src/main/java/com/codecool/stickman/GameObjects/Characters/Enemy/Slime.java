package com.codecool.stickman.GameObjects.Characters.Enemy;

import java.util.Random;

public class Slime extends com.codecool.stickman.GameObjects.Characters.Enemy.Enemy {
    int slimeSplashChanse = 10;

    public Slime(int X, int Y, int level) {
        super(X,Y,12 * level/2,level,level);
        this.hitChanse = 80;
    }

    @Override
    public int attack() {
        Random attackType = new Random();
        int attackRoll = attackType.nextInt();
        if (attackRoll < slimeSplashChanse) {
            return Math.round(level * (10 / 16));
        } else {
            return super.attack();
        }
    }
}
