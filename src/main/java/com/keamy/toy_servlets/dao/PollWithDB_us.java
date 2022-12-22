package com.keamy.toy_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PollWithDB_us {
    public ArrayList<Object> getQuestion(String questionsUid) throws SQLException{

        Commons commons = new Commons();
        Statement statement = commons.getStatement();
        
        ArrayList<Object> bundle_list = new ArrayList<>();
        String query1 = "SELECT * FROM QUESTIONS_LIST " +
                        " WHERE QUESTIONS_UID = '"+questionsUid+"'";
                        
        HashMap<String, Object> question_list = new HashMap<>();
        
        ResultSet resultSet = statement.executeQuery(query1);
        while(resultSet.next()){
            question_list.put("QUESTIONS_UID",resultSet.getString("QUESTIONS_UID"));
            question_list.put("QUESTIONS", resultSet.getString("QUESTIONS"));
            question_list.put("ORDERS",resultSet.getInt("ORDERS"));
        }
        bundle_list.add(question_list);

        String query2 = "SELECT * FROM EXAMPLE_LIST ";
        ArrayList<String> example_list = new ArrayList<>();
        ResultSet resultSet2 = statement.executeQuery(query2);
        while(resultSet2.next()){
            example_list.add(resultSet2.getString("EXAMPLE"));
            System.out.println(resultSet2.getString("EXAMPLE"));
        }
        bundle_list.add(example_list);

        resultSet.close();
        resultSet2.close();
        statement.close();
        return bundle_list;
    }
}
