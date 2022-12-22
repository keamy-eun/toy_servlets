package com.keamy.toy_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


public class DetailWithDB {
    public ArrayList<HashMap> getList(String questionsUid){
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        // 설문과 답항 내용 출력
        String query1 = "SELECT * FROM QUESTIONS_LIST " +
                        " WHERE QUESTIONS_UID = '"+questionsUid+"'";
                
            ArrayList<HashMap> questions_example_list = new ArrayList<HashMap>();
        try {
            ResultSet resultSet = statement.executeQuery(query1);
            while (resultSet.next()) {
                // 설문 문항에 맞는 설문 답항 출력
                HashMap<String, Object> questions_list = new HashMap<String, Object>();
                questions_list.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
                questions_list.put("QUESTIONS", resultSet.getString("QUESTIONS"));
                questions_list.put("ORDERS", resultSet.getInt("ORDERS"));
                questions_example_list.add(questions_list);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions_example_list;
    }
}
