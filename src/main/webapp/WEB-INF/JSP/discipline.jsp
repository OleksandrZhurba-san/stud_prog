<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="links">
  <nav class="link-effect-2" id="link-effect-2">
      <a href="add-discipline"><span data-hover="Добавить">Добавить дисцеплину</span></a>
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
        <td><c:out value="${discipline.name}"/></td>
    </tr>
    </c:forEach>
</table>

