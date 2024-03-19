package com.example.jenkinsdemo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello/*")
public class HelloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String name = "Guest";
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            String[] pathParts = pathInfo.split("/");
            if (pathParts.length > 1) {
                name = pathParts[1];
            }
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Hello " + name + "! </h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}