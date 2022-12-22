package com.keamy.toy_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class PollWithDB_us {
    public HashMap<String, Object> getQuestion(String questionsUid) throws SQLException{

        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM QUESTIONS_LIST " +
                        " WHERE QUESTIONS_UID = '"+questionsUid+"'";
        
        HashMap<String, Object> result = new HashMap<>();
        
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next()){
            result.put("QUESTIONS_UID",resultSet.getString("QUESTIONS_UID"));
            result.put("QUESTIONS", resultSet.getString("QUESTIONS"));
            result.put("ORDERS",resultSet.getInt("ORDERS"));
        }
        resultSet.close();
        statement.close();
        return result;
    }
}
