package com.codecool.stickman.map;
import com.codecool.stickman.GameObjects.Characters.Character;
import com.codecool.stickman.GameObjects.Characters.Player;
import com.codecool.stickman.GameObjects.Characters.Enemy.Enemy;
import com.codecool.stickman.GameObjects.Floor;
import com.codecool.stickman.GameObjects.GameObject;
import com.codecool.stickman.GameObjects.GameObjectType;
import com.codecool.stickman.GameObjects.Wall;

import static com.codecool.stickman.GameObjects.GameObjectType.FLOOR;
import static com.codecool.stickman.GameObjects.GameObjectType.WALL;

public abstract class Level {
    GameObject[][] map;
    int WIDTH;
    int HEIGHT;

    public void move(int toX, int toY, Character movingCharacter){
        int fromX = movingCharacter.getX();
        int fromY = movingCharacter.getY();
        GameObject destination = map[toX][toY];

        switch (map[toX][toY].getType()) {
            case WALL: break;
            case FLOOR: {
                map[toX][toY] = movingCharacter;
                map[fromX][fromY] = destination;
                movingCharacter.place(toX, toY);
                break;
            }
            case LOOT: {
                map[toX][toY] = movingCharacter;
                map[fromX][fromY] = new Floor(fromX, fromY, GameObjectType.FLOOR);
                movingCharacter.place(toX, toY);
                break;
            }
            case ENEMY: {
                if (movingCharacter instanceof Player) {
                    Player player = (Player) movingCharacter;
                    Enemy enemy = (Enemy) destination;
                    player.takeDamage(enemy.attack());
                    enemy.takeDamage(player.attack());
                    if (enemy.getHitPoint() <= 0) {
                        map[toX][toY] = movingCharacter;
                        map[fromX][fromY] = new Floor(fromX, fromY, FLOOR);
                        movingCharacter.place(toX, toY);
                    }
                    break;
                }
            }
        }

    }

    void generateBase(){
        for(int i = 0; i< WIDTH-1; i++){
            for (int j = 1; j<HEIGHT-1; j++) {
                this.map[i][j] = new Floor(i, j, FLOOR);
            }
            this.map[i][0] = new Wall(i,0, WALL);
            this.map[i][HEIGHT-1] = new Wall(i,HEIGHT-1, WALL);
        }
        for(int i = 0; i< HEIGHT-1; i++){
            this.map[0][i] = new Wall(0,i, WALL);
            this.map[WIDTH-1][i] = new Wall(WIDTH-1,i, WALL);
        }
        this.map[WIDTH-1][HEIGHT-1] = new Wall(WIDTH-1,HEIGHT-1, WALL);
    }
}
