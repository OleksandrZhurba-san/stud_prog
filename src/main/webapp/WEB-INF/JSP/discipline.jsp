<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="database.DataServices" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title></title>
</head>
<body>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
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
      <a href="create_discipline"><span data-hover="Добавить">Добавить дисцеплину</span></a>
      <a href="modify_student"><span data-hover="Модифицировать">Модифицировать студента</span></a>
      <a href="delete_discipline"><span data-hover="Удалить">Удалить дисциплину</span></a>
  </nav>
</section>

<table  align="center">
    <h2>Список дисцыплин</h2>
    <tr>
        <th></th>
        <th>Дисциплина</th>
    </tr>
    <c:forEach var="discipline" items="${discipline}">
    <tr>
        <td><input type="checkbox"></td>
        <td><c:out value="${discipline}"/></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
