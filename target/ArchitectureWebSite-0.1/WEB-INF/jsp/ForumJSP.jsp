<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="ru.kpfu.itis.models.Message" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>BUILDINGS</title>
  <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
  <script src="<c:url value="/js/jquery.js"/>"></script>
  <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
</head>
<body>
<div class="page">
  <jsp:include page="/WEB-INF/jsp/elements/Header.jsp"></jsp:include>
  <h1>BUILDINGS</h1>
  <%
    List<Message> messages = (List<Message>) request.getAttribute("msgs");
    for (Message message: messages){
      %>
        <h1><%=message.getAuthor()%></h1>
        <h2><%=message.getName()%></h2>
        <h3><%=message.getInfo()%></h3>
  <%}%>
</div>
</body>
