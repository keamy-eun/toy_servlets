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
      HashMap<String,Object> question = (HashMap<String,Object>)request.getAttribute("question");
    %>
    <a href="/polls/PollServlet_us?QUESTIONS_UID=1">Q1</a> /
    <a href="/polls/PollServlet_us?QUESTIONS_UID=2">Q2</a> /
    <a href="/polls/PollServlet_us?QUESTIONS_UID=3">Q3</a> /
    <a href="/polls/PollServlet_us?QUESTIONS_UID=4">Q4</a> /
    <a href="/polls/PollServlet_us?QUESTIONS_UID=5">Q5</a>
    <div>
      <%= question.get("ORDERS") %>. <%= question.get("QUESTIONS") %>
      2. 주문시 직원은 고객님께 친절하였습니까?
    </div>
    <div>(1) Never (2) nope (3) normal</div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
