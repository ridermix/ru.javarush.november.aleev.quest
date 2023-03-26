<%@ page contentType="text/html;charset=UTF-8"%>

<head>
    <title>Game</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<form class="form-horizontal" action="game" method="get">
    <div class="form-group">
        <div class="col-md-4">
        </div>
        <div>
            <h1 align="center"><%= request.getAttribute("questionText") %>
            </h1>
            <br>
        </div>
        <div class="container">
            <div class="form-check">

                <input class="form-check-input" type="radio" name="answer" value="0" id="0">
                <label class="form-check-label" for="0">
                    <%= request.getAttribute("answer1") %>
                </label>
                <br>
                <input class="form-check-input" type="radio" name="answer" value="1" id="1">
                <label class="form-check-label" for="1">
                    <%= request.getAttribute("answer2") %>
                </label>
            </div>


            <div class=" form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" class="btn btn-success">Играть</button>
                </div>
            </div>
            <br>
            <div>
                <h5 class="uk-heading-medium">Игрок: <%= request.getSession().getAttribute("name") %>
                </h5>
                <h5 class="uk-heading-medium">Статистика игр: <%= request.getSession().getAttribute("count") %>
                </h5>
            </div>
        </div>

    </div>
</form>
</body>


