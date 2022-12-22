package com.keamy.toy_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.keamy.toy_servlets.dao.SimpleWithDB;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns = "/simple/WithDBServlets")
public class SimpleWithDBServlets extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        // biz with DB
        SimpleWithDB simpleWithDB = new SimpleWithDB();
        ArrayList<HashMap> bundle_list = simpleWithDB.getList();

        // display
        PrintWriter pw = response.getWriter();
        pw.println("<div>SimpleWithDBServlets</div>");
        
        for(int i=0; i<bundle_list.size(); i++){
            int num= 0;
            HashMap<String, Object> bundle = bundle_list.get(i);

            //question
            HashMap<String, Object> question = (HashMap<String, Object>) bundle.get("question");
            int questions_order = (int) question.get("ORDERS");
            String questions = (String) question.get("QUESTIONS");
            String questions_uid = (String) question.get("QUESTIONS_UID");
            pw.println("<div>" + questions_order + ". " + questions + "<input type='hidden' value='"+questions_uid+"'/></div>");
        
            //answer
            ArrayList<HashMap> example_list = (ArrayList<HashMap>) bundle.get("example_list");
            while(num < example_list.size()){
                example_list = (ArrayList<HashMap>) bundle.get("example_list");
                HashMap<String, Object> answer = example_list.get(num);
                int examples_order = (int) answer.get("ORDERS");
                String examples = (String) answer.get("EXAMPLE");
                String examples_uid = (String) answer.get("EXAMPLE_UID");
                pw.println("<div>" + examples_order + ". " + examples + "<input type='hidden' value='"+examples_uid+"'/></div>");
                num++;
            }
        }        
        pw.close();
    }
}
