package com.codecool.stickman.GameObjects.Items;

import com.codecool.stickman.GameObjects.GameObject;
import com.codecool.stickman.GameObjects.GameObjectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loot extends GameObject {
    private List<Item> loot = new ArrayList<>();
//    private ItemsDataDao itemsList = ItemsDataDao.getInstance();
    private int gold;
    private Random random = new Random();

    public Loot(int X, int Y) {
        super(X,Y);
        this.type = GameObjectType.LOOT;
        this.gold = random.nextInt(10) + 1;
        add();
    }

    public void add() {
        int numberOfLoots = random.nextInt(3) + 1;
        fillUpLoot(numberOfLoots);
    }

    private void fillUpLoot(int numberOfLoots) {
//        for (int i = 0; i < numberOfLoots; i++) {
//            GameObject item = itemsList.getRandom();
//            if (item instanceof Item) {
//                loot.add((Item) item);
//            }
//        }
    }

    public List<Item> getItems() {
        return new ArrayList<>(loot);
    }

    public int getGold() {
        return gold;
    }
}
