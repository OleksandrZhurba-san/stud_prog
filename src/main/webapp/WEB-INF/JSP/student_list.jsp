<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Students" %>
<%@ page import="database.DataServices" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
  <link rel="stylesheet" type="text/css" href="resources/css/style.css">
  <title></title>
</head>
<body>
<div id="title"><h1> Система управления студентами и их успеваемостью</h1></div>
<div class="nav">
    <ul>
        <li class="home"><a href="students">Студенты</a></li>
        <li class="discipline"><a  href="discipline">Дисцыплины</a></li>
        <li class="terms"><a href="terms">Семестры</a></li>
        <li calss="logout"><a href="logout">Logout</a> </li>
    </ul>

</div>
<section class="links">
    <nav class="link-effect-2" id="link-effect-2">
        <a href="create_student"><span data-hover="Добавить">Добавить студента</span></a>
        <a href="delete_student"><span data-hover="Удалить">Удалить студента</span></a>
        <a href="modify_student"><span data-hover="Модифицировать">Модифицировать студента</span></a>
        <a href="view_student"><span data-hover="Просмотр">Просмотр успеваемости студента</span></a>
    </nav>
</section>

<table align="center">
    <h2>Список студентов</h2>
    <tr>
        <th></th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Группа</th>
        <th>Дата поступления</th>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td><input type="checkbox"></td>
            <td><c:out value="${student.first_name}"/></td>
            <td><c:out value="${student.last_name}"/></td>
            <td><c:out value="${student.group}"/></td>
            <td><c:out value="${student.date}"/></td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
