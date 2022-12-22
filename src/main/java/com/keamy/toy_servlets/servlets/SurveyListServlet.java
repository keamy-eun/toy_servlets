package com.keamy.toy_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.keamy.toy_servlets.HashMaps.DataInfo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/pollListServlet")
public class SurveyListServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");

        DataInfo dataInfo = new DataInfo();
        HashMap<String, Object> bundlesData = dataInfo.getBundlesData();

        PrintWriter pw = response.getWriter();
        
        pw.println("");
        pw.println("<html lang='en'>");
        pw.println("<head>");
        pw.println("<meta charset='UTF-8' />");
        pw.println("  <title>Document</title>");
        pw.println("<link");
        pw.println("href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'");
        pw.println("rel='stylesheet'");
        pw.println("integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65'");
        pw.println("crossorigin='anonymous'");
        pw.println("/>");
        pw.println("</head>");
        pw.println("<body>");

        HashMap<String, String> questionsList = (HashMap<String, String>) bundlesData.get("getQuestionsList");
        HashMap<String, String> answersList = (HashMap<String, String>) bundlesData.get("getAnswersList");
        HashMap<String, String> idList = (HashMap<String, String>) bundlesData.get("getIdList");
        // 1번 3, 2번 4,3번 2,4번 5, 5번 3

        pw.println("<div>"+idList.get("본인 이름")+"</div>");
        pw.println("<div>"+idList.get("본인 소속")+"</div>");
        
        pw.println("<form action='#' method='get' class='border border-3 m-5 container'>");
        pw.println("<div class='container'>");
        pw.println("<p class='fs-2 mt-5'>설문 페이지</p>");
        pw.println("<p>(하나의 질문에 한 가지 답항만 선택 가능합니다.)</p>");

        int[] questionAmount = {3,4,2,5,3};
        for(int i=1; i<=questionAmount.length; i++){
            pw.println("<div>"+i+" : "+questionsList.get(i)+"</div>");
            pw.println("<div>");
            pw.println("<div class='row container mb-3'>");
            for( int j=1; j<=questionAmount[i-1]; j++){

                pw.println("    <div class='col-2 form-check'>");
                pw.println("        <input");
                pw.println("        type='radio'");
                pw.println("        class='form-check-input'");
                pw.println("        name='radio0"+i+"'");
                pw.println("        id='default-radio'");
                pw.println("        value='"+i+"-"+j+"'");
                pw.println("        />");
                pw.println("        <label for='radio0"+i+"' class='form-check-label'");
                pw.println("        >"+answersList.get(j)+"</label");
                pw.println("        >");
                pw.println("    </div>");
            }
            pw.println("</div>");
            pw.println("</div>");
        }
        pw.println("</div>");
        pw.println("</form>");
        pw.println("</body>");
        pw.println("</html>");

        pw.close();
    }
}
