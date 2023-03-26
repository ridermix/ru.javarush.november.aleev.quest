<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>JavaRush Quest</title>

    <%-- TO DO - style don't work   --%>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
<br>
<h1 align="center"><%= "Пролог" %>
</h1>
<h4>
    <div class="container" align="justify">

        Ты стоишь в космическом порту и готов подняться на борт

        своего корабля. Разве ты не об этом мечтал? Стать капитаном

        галактического судна с экипажем, который будет совершать

        подвиги под твоим командованием.

        Так что вперед!


    </div>

</h4>
<br/>
<h1 align="center"><%="Знакомство с экипажем"%>
</h1>
<h4>
    <div class="container" align="justify">
        Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:

        - Здравствуйте, командир! Я Зинаида - ваша помощница. Видите? Там в углу пьет кофе

        наш штурман - сержант Перегарный Шлейф, под штурвалом спит наш бортмеханик - Черный Богдан,

        а фотографирует его Сергей Стальная Пятка - наш навигатор.

        А как обращаться к вам?
        <br/>
    </div>
</h4>
<br>
<form class="form-horizontal" action="create" method="get">
    <div class="container">

        <div class="col-md-4">
            <div class="g-4 py-5 row-cols-1 row-cols-lg-3">
                <input id="name" name="name" type="text" placeholder="Введите имя" class="form-control input-md">
            </div>

            <div class="container">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" class="btn btn-success">Представиться</button>
                    <br/>
                    <br/>


                </div>
            </div>
            <div> Дата прохождения квеста: <%= new java.util.Date()%>
            </div>
        </div>
    </div>
</form>

</body>
</html>