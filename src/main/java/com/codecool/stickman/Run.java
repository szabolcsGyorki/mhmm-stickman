package com.codecool.stickman;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Test", urlPatterns = {"/"})
public class Run extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println(
                "<html>\n" +
                "<head><title>Another page</title></head>\n" +
                "<body>\n" +
                "<h1>Hello CodeCooler!</h1>" +
                "<br/>" +
                "<div><a href=\"/\">Back to home</a></div>" +
                "</body></html>"
        );
    }
}