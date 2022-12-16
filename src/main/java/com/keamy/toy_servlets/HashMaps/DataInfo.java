package com.keamy.toy_servlets.HashMaps;

import java.util.HashMap;

public class DataInfo {

    // 형식상 HashMap<String, Object>를 넣어줬다
    public HashMap<String, Object> getBundlesData(){
        DataInfo dataInfo = new DataInfo();
        HashMap<String, Object> bundlesData = new HashMap<>();
        bundlesData.put("getQuestionsList", dataInfo.getQuestionsList());
        bundlesData.put("getAnswersList", dataInfo.getAnswersList());
        bundlesData.put("getIdList", dataInfo.getIdList());

        return bundlesData;
    }

    public HashMap<Integer, String> getQuestionsList(){
        HashMap<Integer, String> questionsList = new HashMap<>();
        questionsList.put(1, "해당 매장을 방문시 매장은 청결 하였습니까?");
        questionsList.put(2, "직원이 제조한 음료에 대해 맛은 좋았습니까?");
        questionsList.put(3, "주문시 직원은 고객님께 친절 하였습니까?");
        questionsList.put(4, "해당 매장을 다음에도 재방문 하실 의향이 있으십니까?");
        questionsList.put(5, "주문하신 음료가 나오기까지 시간이 적당하였습니까?");
        return questionsList;
    }
    public HashMap<Integer, String> getAnswersList(){
        HashMap<Integer, String> answersList = new HashMap<>();
        answersList.put(1, "전혀 아니다");
        answersList.put(2, "아니다");
        answersList.put(3, "보통이다");
        answersList.put(4, "그렇다");
        answersList.put(5, "매우 그렇다");
        return answersList;
    }
    public HashMap<String, String> getIdList(){
        HashMap<String, String> idList = new HashMap<>();
        idList.put("본인 이름", "은원기");
        idList.put("본인 소속", "무소속");
        return idList;
    }
}
