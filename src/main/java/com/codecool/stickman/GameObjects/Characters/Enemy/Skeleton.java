package com.codecool.stickman.GameObjects.Characters.Enemy;

import com.codecool.stickman.GameObjects.GameObjectType;

public class Skeleton extends Enemy {
    public Skeleton(int X, int Y, int level){
        super(X,Y,6 * level,Math.round(level * (3/2)),level);
        this.dodgeChanse = 25;
        this.type = GameObjectType.SKELETON;
    }
}
