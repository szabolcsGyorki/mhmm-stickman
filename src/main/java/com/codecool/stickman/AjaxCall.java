package com.codecool.stickman;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.codecool.stickman.GameObjects.Characters.Player;
import com.codecool.stickman.GameObjects.GameObject;
import com.codecool.stickman.GameObjects.GameObjectType;
import com.codecool.stickman.GameObjects.Items.Armor;
import com.codecool.stickman.GameObjects.Items.Item;
import com.codecool.stickman.GameObjects.Items.Weapon;
import com.codecool.stickman.map.Level;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import static com.codecool.stickman.GameObjects.GameObjectType.*;

@WebServlet(urlPatterns = {"/send"})
public class AjaxCall extends HttpServlet {
    Player Zsolt;
    Level levelOne;
    Boolean demoLoad = false;
    public void initForDemo(){
        levelOne = new Level(10,10 ,WALL, FLOOR);
        Zsolt = new Player(1,5);
        levelOne.placeWall(2,2);
        levelOne.placeEnemy(1,1,SLIME,1);
        levelOne.placeEnemy(1,2,SKELETON,1);
        levelOne.placeEnemy(1,3,ORC,1);
        levelOne.placeEnemy(1,4,DRAGON,1);
        levelOne.placePlayer(Zsolt);
        demoLoad = true;
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!demoLoad) { initForDemo(); }    // For demo only
        String actionRequired = req.getHeader("action");
        switch (actionRequired){
            case "up":{
                if(Zsolt.getY() < levelOne.getHEIGHT())
                levelOne.move(Zsolt.getX(), Zsolt.getY()+1, Zsolt);
            }
            case "down":{
                if(Zsolt.getY() > 0)
                levelOne.move(Zsolt.getX(), Zsolt.getY()-1, Zsolt);
            }
            case "right": {
                if(Zsolt.getX() < levelOne.getWIDTH())
                levelOne.move(Zsolt.getX()+1, Zsolt.getY(), Zsolt);
            }
            case "left": {
                if(Zsolt.getX() > 0)
                levelOne.move(Zsolt.getX()-1, Zsolt.getY(), Zsolt);
            }
            case "map": {
                break;
            }
        }

        //resp.getWriter().write(levelToJson(INSERT LIST HERE).toJSONString());

        resp.getWriter().write(levelToJson(levelOne.getMap()).toJSONString());
        resp.getWriter().write(characterToJson(Zsolt).toJSONString());

    }

    /**
     * Converts a list of GameObjects to a JSONObject that's AJAX response ready
     * @return JSONArray with JSONObjects
     */
    @SuppressWarnings("unchecked")
    private JSONArray levelToJson (ArrayList<GameObject> gameObjects) {
        JSONArray gameObjectsJSONArray = new JSONArray();

        for (GameObject gameObject: gameObjects) {
            JSONObject obj = new JSONObject();
            obj.put("name", gameObject.getType().toString());
            obj.put("x", gameObject.getX());
            obj.put("y", gameObject.getY());
            gameObjectsJSONArray.add(obj);
        }
        return gameObjectsJSONArray;
    }

    @SuppressWarnings("unchecked")
    private JSONObject characterToJson (Player player) {
        JSONObject character = new JSONObject();
        JSONArray characterInventory = new JSONArray();

        //filling inventory
        for (Item item: player.getItems()) {
            JSONObject jsonItem = new JSONObject();

            jsonItem.put("name", item.getName());
            if (item instanceof Weapon) {
                jsonItem.put("maxDamage", ((Weapon) item).getMaxDamage());
                jsonItem.put("minDamage", ((Weapon) item).getMinDamage());
            } else {
                jsonItem.put("healthIncrease", ((Armor) item).getHealthIncrease());
            }
            characterInventory.add(jsonItem);
        }

        //filling character details
        character.put("hp", player.getHitPoint());
        character.put("str", player.getStrength());
        character.put("agi", player.getAgility());
        character.put("int", player.getIntelligence());

        character.put("inventory", characterInventory);

        return character;
    }

}
