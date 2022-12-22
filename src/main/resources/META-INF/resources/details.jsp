<%@ page import="java.util.HashMap, java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <%! int cnt = 1; %>
    <% ArrayList<HashMap> bundle_list = (ArrayList<HashMap>)request.getAttribute("questions_example_list"); %>
      <% String order = request.getParameter("ORDER"); %>
      <div>order = <%= order %></div>
      <a href="/poll/DetailServlets?ORDER=<%= cnt++%>">awef</a>
      <button class="btn btn-outline-primary" id="1" onclick="location.href='/poll/DetailServlets?ORDER='+<%= cnt--%>">Next</button>
      <a href="/poll/DetailServlets?ORDER=<%= cnt++%>">124</a>
      <% int intOrder = 0; %>
      <% if(order==null) { %>
        <div><%= bundle_list.get(0).get("ORDERS")+". "+bundle_list.get(0).get("QUESTIONS")%></div>
        <div><%= bundle_list.get(0).get("EXAMPLE")%></div>
        <% } else { %>
        <% intOrder = Integer.parseInt(order); %>
          <div><%= bundle_list.get(intOrder).get("ORDERS")+". "+bundle_list.get(intOrder).get("QUESTIONS")%></div>
        <div><%= bundle_list.get(intOrder).get("EXAMPLE")%></div>
          <% } %>
          
        <div>cnt = <%= cnt %></div>
        

          
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
