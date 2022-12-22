package com.keamy.toy_servlets.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.keamy.toy_servlets.dao.DetailWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/poll/DetailServlets")
public class DetailServlets extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        // biz with DB

        String questions_Uid = request.getParameter("QUESTIONS_UID");

        DetailWithDB simpleWithDB = new DetailWithDB();
        ArrayList<HashMap> questions_example_list = simpleWithDB.getList(questions_Uid);
        request.setAttribute("questions_example_list", questions_example_list);
        request.setAttribute("ORDER", 0);

        

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/details.jsp");
        requestDispatcher.forward(request, response);

    }
}
