package com.codecool.stickman;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

@WebServlet(urlPatterns = {"/send"})
public class AjaxCall extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String asd[][] = new String [5][5];


        JSONObject mylist = new JSONObject();

        JSONObject obj = new JSONObject();
        obj.put("name", "WALL");
        obj.put("x", 0);
        obj.put("y", 0);

        JSONArray arr2 = new JSONArray();

        arr2.add(obj);

        resp.getWriter().write(arr2.toJSONString());

    }


}
