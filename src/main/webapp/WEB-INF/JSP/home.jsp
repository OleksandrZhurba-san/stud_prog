<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <script type="text/javascript" src="${CONTEXT} resources/js/main.js"></script>
    <link rel="stylesheet" type="text/css" href=${CONTEXT}"resources/css/style.css">
    <link href=${CONTEXT}"resources/css/ui-lightness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
    <script src=${CONTEXT}"resources/js/jquery-1.10.2.js"></script>
    <script src=${CONTEXT}"resources/js/jquery-ui-1.10.4.custom.js"></script>

    <script src="${CONTEXT} resources/js/jquery.ui.datepicker-ru.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $("#datepicker").datepicker({dateFormat: "yy-mm-dd"});
            $("#datepicker").datepicker();
        });
    </script>
    <title> Система управления студентами и их успеваемостью</title>
</head>

<body>
<div id="title"><h1> Система управления студентами и их успеваемостью</h1></div>

<c:if test="${currentPage ne 'login.jsp'}">
    <div class="nav">
        <ul>
            <li class="home"><a href="students">Студенты</a></li>
            <li class="tutorials"><a href="discipline">Дисцыплины</a></li>
            <li class="about"><a href="terms">Семестры</a></li>
            <li calss="logout"><a href="logout">Logout</a></li>
        </ul>
    </div>
</c:if>


<jsp:include page="${currentPage}"></jsp:include>
</body>

</html>