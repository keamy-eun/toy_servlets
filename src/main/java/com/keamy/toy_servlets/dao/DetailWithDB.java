package com.keamy.toy_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


public class DetailWithDB {
    public ArrayList<HashMap> getList(){
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        // 설문과 답항 내용 출력
        String query = "SELECT * FROM questions_example_list " +
                "ORDER BY ORDERS";
            ArrayList<HashMap> questions_example_list = new ArrayList<HashMap>();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                // 설문 문항에 맞는 설문 답항 출력
                HashMap<String, Object> questions_example = new HashMap<String, Object>();
                questions_example.put("QUESTIONS", resultSet.getString("QUESTIONS"));
                questions_example.put("EXAMPLE", resultSet.getString("EXAMPLE"));
                questions_example.put("ORDERS", resultSet.getInt("ORDERS"));
                questions_example_list.add(questions_example);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions_example_list;
    }
}
