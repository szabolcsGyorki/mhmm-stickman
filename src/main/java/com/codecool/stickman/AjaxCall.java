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
import com.codecool.stickman.map.Level;
import com.codecool.stickman.map.LevelOne;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

@WebServlet(urlPatterns = {"/send"})
public class AjaxCall extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.getWriter().write(levelToJson(INSERT LIST HERE).toJSONString());

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
