package com.codecool.stickman.GameObjects.Characters.Enemy;

public class Dragon extends Enemy {
    int fireBreathTimer;
    public Dragon(int X, int Y, int level) {
        super(X, Y, 100 + level*20, 15 + level*5, level);
        armor = 20 + level*3;
        dodgeChanse = 15;
        hitChanse = 90;
        fireBreathTimer = 2;
    }

    @Override
    public int attack() {
        if (fireBreathTimer < 1) {
            fireBreathTimer = 3;
            return level*5 + super.attack();
        }
        fireBreathTimer -= 1;
        return super.attack();
    }
}
