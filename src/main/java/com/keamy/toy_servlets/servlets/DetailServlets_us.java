package com.keamy.toy_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import com.keamy.toy_servlets.dao.PollWithDB_us;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/polls/PollServlet_us")
public class DetailServlets_us extends HttpServlet{
    @Override  //request는 client가 보내온것
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // input type
        String questions_Uid = request.getParameter("QUESTIONS_UID");

        // biz with DB and Class
        PollWithDB_us pollWithDB = new PollWithDB_us();
        HashMap<String, Object> question = null;
        try {
            question = pollWithDB.getQuestion(questions_Uid);
            System.out.println(question.get("QUESTIONS_UID"));
            System.out.println(question.get("QUESTIONS"));
            System.out.println(question.get("ORDERS"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // output with html
        request.setAttribute("question", question);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/details_us.jsp");
        requestDispatcher.forward(request, response);
    }
}
