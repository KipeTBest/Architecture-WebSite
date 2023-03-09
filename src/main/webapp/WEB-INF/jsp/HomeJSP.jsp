<%@ page import="ru.kpfu.itis.models.UserModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HOME</title>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/js/jquery.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/css/aboutPage.css"/>" type="text/css">
</head>
<body>
    <div class="page">
        <jsp:include page="/WEB-INF/jsp/elements/Header.jsp"></jsp:include>
        <div class="home">
            <div class="home__about-field">
                <p class="home__about-field__text">
                    Architecture - minecraft-сервер на версии 1.19.3 со своими уникальными плагинами,
                    модами и дружным комьюнити. Мы даем вам площадку для реализации самых необычных идей, которыми вы можете поделиться
                    с другими игроками. У нас провядтся турниры по строительству, мы сотрудничаем с рядом популярных серверов, а самые
                    популярные игроки и их постройки попадают в топ или их нанимают builder'ы различных серверов для украшения своих миров!
                </p>
                <hr class="home__about-field__hr">
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="<c:url value="/res/HomeVanillaCore.png"/>" class="d-block w-100">
                        </div>
                        <div class="carousel-item">
                            <img src="<c:url value="/res/HomeCreativeCore.png"/>" class="d-block w-100">
                        </div>
                        <div class="carousel-item">
                            <img src="<c:url value="/res/HomeChampionCore.png"/>" class="d-block w-100">
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-target="#carouselExampleControls" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Предыдущий</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-target="#carouselExampleControls" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Следующий</span>
                    </button>
                </div>
                <hr class="home__about-field__hr">
                <%
                    UserModel user = (UserModel) session.getAttribute("user");
                    if (user == null){
                        user = UserModel.builder().name("Зарегайся")
                                .build();
                    }
                %>
                <h1>Привет пользователь:</h1>
                <h1><%=user.getName()%></h1>
            </div>
        </div>
    </div>
</body>
