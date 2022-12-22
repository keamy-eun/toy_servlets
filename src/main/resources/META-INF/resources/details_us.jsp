<%@ page import="java.util.HashMap, java.util.ArrayList" %> <%@ page
language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="./css/commons.css" />
  </head>
  <body>
    <%
      HashMap<String,Object> question_list = (HashMap<String,Object>)request.getAttribute("question_list");
      ArrayList<String> example_list = (ArrayList<String>) request.getAttribute("example_list");
    %>
    <% for(int i=1; i<6; i++){ %>
      <a href="/polls/PollServlet_us?QUESTIONS_UID=Q<%= i%>">Q<%= i%></a> /
      <% } %>
    <div>
      <%= question_list.get("ORDERS") %>. <%= question_list.get("QUESTIONS") %>
    </div>
    <% for(int i=0; i<example_list.size(); i++){%>
      <div><%= "("+(i+1)+") "+example_list.get(i) %></div>
      <% }%>
    
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
