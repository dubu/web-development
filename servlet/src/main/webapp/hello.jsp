<%@ page import="com.dubu.model.MessageStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    com.dubu.model.MessageStore model = new com.dubu.model.MessageStore();
    model.setMessage("Hi");
%>
<html>
  <head>
    <title></title>
  </head>
  <body>
         Welcome *^^*  <BR>
         <%=model.getMessage()%>
  </body>
</html>