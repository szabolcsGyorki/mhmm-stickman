package com.codecool.stickman.map;
import static com.codecool.stickman.GameObjects.GameObjectType.FLOOR;
import static com.codecool.stickman.GameObjects.GameObjectType.FOREST;

import com.codecool.stickman.GameObjects.Characters.Player;
import com.codecool.stickman.GameObjects.Characters.Enemy.Slime;
import com.codecool.stickman.GameObjects.Floor;
import com.codecool.stickman.GameObjects.GameObject;
import com.codecool.stickman.GameObjects.GameObjectType;
import com.codecool.stickman.GameObjects.Items.Item;
import com.codecool.stickman.GameObjects.Wall;

public class LevelOne extends Level{

    public LevelOne(Player player){
        HEIGHT = 12;
        WIDTH = 8;
        this.map = new GameObject[WIDTH][HEIGHT];


        generateBase();

        this.map[1][1] = player;
        player.place(1,1);

        this.map[4][4] = new Slime(4,4);
        this.map[3][4] = new Slime(3,4);
        this.map[2][4] = new Slime(2,4);
    }

    public GameObject[][] getLevel(){
        return this.map;
    }


}