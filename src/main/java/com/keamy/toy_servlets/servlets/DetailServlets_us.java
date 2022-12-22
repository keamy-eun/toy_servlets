package com.keamy.toy_servlets.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
        HashMap<String, Object> question_list = null;
        ArrayList<String> example_list = null;
        try {
        ArrayList<Object> bundle_list = pollWithDB.getQuestion(questions_Uid);

        question_list = (HashMap<String, Object>) bundle_list.get(0);
            System.out.println(question_list.get("QUESTIONS_UID"));
            System.out.println(question_list.get("QUESTIONS"));
            System.out.println(question_list.get("ORDERS"));

        example_list = (ArrayList<String>) bundle_list.get(1);
        for(int i=0; i<example_list.size(); i++){
            System.out.println(example_list.get(i));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // output with html
        request.setAttribute("question_list", question_list);
        request.setAttribute("example_list", example_list);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/details_us.jsp");
        requestDispatcher.forward(request, response);
    }
}
