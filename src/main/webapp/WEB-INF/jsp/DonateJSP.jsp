<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>DONATE</title>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/js/jquery.js"/>"></script>
    <script src="<c:url value="/js/donateJS.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/css/aboutPage.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" type="text/css">
</head>
<body>
    <div class="page">
        <jsp:include page="/WEB-INF/jsp/elements/Header.jsp"></jsp:include>
        <div class="donate">
            <div class="donate__information">
                <p class="donate__information-txt">
                    Для упрощения игры на наших серверах, вы можете купить игровые предметы за реальные деньги.
                    Обращаем ваше внимание, что все вопросы, которые могут возникнуть, разобраны до вас. Если
                    вы не нашли ответ на интересующий вас вопрос, то свяжитесь с нами. Наша администрация
                    постарается помочь вам в течение нескольких часов.
                </p>
            </div>
            <div class="donate__controller">
                <h2 class="donate__controller-article">
                    Введите ник пользователя:
                </h2>
                <input class="donate__controller__nickname">
                <h2 class="donate__controller-article">
                    Выберите сервер:
                </h2>
                <select class="donate__controller__server"></select>
                <h2 class="donate__controller__purchase">
                    Выберите услугу:
                </h2>
                <select class="donate__controller__purchase"></select>
            </div>
            <div class="donate__qanda">
                <p class="donate__qanda-txt">
                    Ниже приведен список вопросов и ответов на них. Если вы не нашли ответ на свой вопрос,
                    задайте его нам!
                </p>
                <!-- список вопросов --->
            </div>
        </div>
    </div>
</body>
