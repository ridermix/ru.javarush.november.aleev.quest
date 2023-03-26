<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <title>YOU WIN</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <form class="form-horizontal" action="index.jsp" method="get">
        <div class="form-group">
            <div class="col-md-4"></div>
            <div><h1 style="color: green"><%= request.getAttribute("questionText")%></h1></div>
            <div><%request.getSession().setAttribute("id", null);%></div>
        </div>
        <div>
            ДАТА: <%= new java.util.Date()%>
        </div>
        <br>
        <div class="form-group">
            <label class="col-md-4 control-label" for="submit"></label>
            <div class="col-md-4">
                <button id="submit" class="btn btn-success">Начать заново</button>
            </div>
        </div>
    </form>

</div>


</body>
</html>
