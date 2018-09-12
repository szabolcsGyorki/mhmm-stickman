package com.codecool.stickman.GameObjects.Characters.Enemy;
import com.codecool.stickman.GameObjects.Characters.Character;
import static com.codecool.stickman.GameObjects.GameObjectType.ENEMY;

public abstract class Enemy extends Character {
    public Enemy(int X, int Y, int hitPoints, int damage){
        super(X,Y,hitPoints,damage);
        this.type = ENEMY;
    }

    public int attack(){
        return this.damage;
    }

}
