<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>LEADERBOARD</title>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/js/jquery.js"/>"></script>
    <script src="<c:url value="/js/lboardJS.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/css/aboutPage.css"/>" type="text/css">
</head>
<body>
    <div class="page">
        <jsp:include page="/WEB-INF/jsp/elements/Header.jsp"></jsp:include>
        <div class="lboard">
            <div class="lboard__article">
                <p class="lboard__article-txt">
                    smth
                </p>
            </div>
            <div class="lboard__board">

            </div>
        </div>
    </div>
</body>
