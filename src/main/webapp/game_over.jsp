<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <title>GAME OVER</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<br>
<body>
<div class="container">
    <form class="form-horizontal" action="index.jsp" method="get">
        <div class="form-group">
            <div class="col-md-4">
            </div>
            <div>
                <h1 style="color: red"><%= request.getAttribute("questionText") %> </h1>
            </div>
            <div>
                <% request.getSession().setAttribute("id" , null);
                %>
            </div>

        </div>
        <div>
            Дата: <%= new java.util.Date()%>
        </div>
        <br>

        <div>
            <div class=" form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" class="btn btn-success">Начать заново</button>
                </div>
            </div>

        </div>

    </form>

</div>


</body>
</html>
