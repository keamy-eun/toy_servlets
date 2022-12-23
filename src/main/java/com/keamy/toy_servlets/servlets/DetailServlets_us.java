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
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questions_Uid = request.getParameter("QUESTIONS_UID");
        
        // biz with DB and Class
        PollWithDB_us pollWithDB = new PollWithDB_us();
        HashMap<String, Object> question_list = null;
        ArrayList<String> example_list = null;
        try {
        //답항,문항을 담은 ArrayList
        ArrayList<Object> bundle_list = pollWithDB.getQuestion(questions_Uid);

        //문항
        question_list = (HashMap<String, Object>) bundle_list.get(0);

        //답항
        example_list = (ArrayList<String>) bundle_list.get(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 답항,문항을 jsp로 넘김
        request.setAttribute("question_list", question_list);
        request.setAttribute("example_list", example_list);
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/details_us.jsp");
        requestDispatcher.forward(request, response);
    }
}
