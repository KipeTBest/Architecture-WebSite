<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SERVER</title>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/js/jquery.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" type="text/css">
    <link rel="stylesheet" href="<c:url value="/css/aboutPage.css"/>" type="text/css">
</head>
<body>
<div class="page">
    <jsp:include page="/WEB-INF/jsp/elements/Header.jsp"></jsp:include>
    <div class="server">
        <div class="server__col-1">
            <div class="server__col__article">
                <p class="server__col__article-txt">
                    Vanilla Core
                </p>
            </div>
            <div class="server__col__content">
                <p class="server__col__content-txt">
                    Ванильный сервер на версии 1.19.3. Добавленно несколько плагинов, упрощяющих
                    выживание и игровой процесс. Размер мира 60тыс x 60тыс блоков.
                    <br>
                    <hr style="margin: auto">
                    <p style="font-size: 24px; text-align: center">
                        ONLINE: 0/300 <br> ip: archVanilla:play.ru</p>
                </p>
            </div>
        </div>
        <div class="server__col-2">
            <div class="server__col__article">
                <p class="server__col__article-txt">
                    Creative Core
                </p>
            </div>
            <div class="server__col__content">
                <p class="server__col__content-txt">
                    Творческий сервер. Супер-плоский мир с уникальным щаблоном генерации.
                    Доступны плагины WorldEdit на своей тер-рии. Мир 100тыс x 100тыс блоков.
                    Объединяйтесь в группы и создавайте масштабные проекты! Мир вайпается (с сохранением всех
                    построек) по голосованию игроков раз в 2 месяца.
                    <br>
                    <hr style="margin: auto">
                    <p style="font-size: 24px; text-align: center">
                        ONLINE: 0/300 <br> ip: archCreative:play.ru</p>
                </p>
            </div>
        </div>
        <div class="server__col-3">
            <div class="server__col__article">
                <p class="server__col__article-txt">
                    Champion Core
                </p>
            </div>
            <div class="server__col__content">
                <p class="server__col__content-txt">
                    Сервер для проведения турниров среди строителей! На страничке "News" или
                    "Tournament" оглашаются мероприятия и регистрация на турннир. Открывается только
                    во время самих турниров, вход только по whitelist'у (требуется регистрация на турнир)
                    <br>
                    <hr style="margin: auto">
                    <p style="font-size: 24px; text-align: center">
                        ONLINE: CLOSED <br> ip: archTournament:play.ru</p>
                </p>
            </div>
        </div>
    </div>
</div>
</body>
