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
<table id="table_student" align="center">
    <p id="p_student_list"><h2>Список студентов</h2></p>
    <tr>
        <th></th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Группа</th>
        <th>Дата поступления</th>
    </tr>
    <c:forEach var="person" items="${studentList}">
        <tr>
            <td><input type="checkbox" name="checkboxStudent"></td>
            <td><c:out value="${person.first_name}"/></td>
            <td><c:out value="${person.last_name}"/></td>
            <td><c:out value="${person.group}"/></td>
            <td><c:out value="${person.date}"/></td>
        </tr>
    </c:forEach>


</table>
</body>
</html>
