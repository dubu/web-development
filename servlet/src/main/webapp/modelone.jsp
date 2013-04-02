<%@ page import="com.dubu.model.Person" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 13. 4. 1
  Time: 오후 5:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="servie" class="com.dubu.service.PersonServiceInMemory"  scope="request" />

<% Person person = servie.search(Integer.valueOf(request.getParameter("id"))); %>

<html>
<head>
    <title></title>
</head>
<body>


model one jsp
<h1> name : <%=person.getName()%></h1>
<h1>age :  <%=person.getAge()%> </h1>

</body>
</html>