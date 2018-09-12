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
import com.codecool.stickman.map.Level;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import static com.codecool.stickman.GameObjects.GameObjectType.*;

@WebServlet(urlPatterns = {"/send"})
public class AjaxCall extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionRequired = req.getHeader("action");
        //resp.getWriter().write(levelToJson(INSERT LIST HERE).toJSONString());
        Level levelOne = new Level(10,10 ,WALL, FLOOR);
        levelOne.placeWall(2,2);
        levelOne.placeEnemy(1,1,SLIME,1);
        levelOne.placeEnemy(1,2,SKELETON,1);
        levelOne.placeEnemy(1,3,ORC,1);
        levelOne.placeEnemy(1,4,DRAGON,1);
        Player Zsolt = new Player(1,5);
        levelOne.placePlayer(Zsolt);
        resp.getWriter().write(levelToJson(levelOne.getMap()).toJSONString());

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

}
