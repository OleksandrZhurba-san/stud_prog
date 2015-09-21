<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    function deleteStudents() {
        var items = $("input[type=checkbox]:checked");
        if (items.length == 0) {
            alert("Please select students");
            return;
        }
        var ids = "";
        for ( var i = 0; i < items.length; i++) {
            ids += $(items[i]).attr("id");
            if (i < items.length - 1) {
                ids += ",";
            }
        }

        console.log(ids);
        console.log("ids=" + ids);
        var form = '<form id="deleteStudentForm" action="student-del" method="post"><input type="hidden" name="ids" /></form>';
        $("body").append(form);
        $('#deleteStudentForm input').val(ids);
        $('#deleteStudentForm').submit();

    }
</script>
<section class="links">
    <nav class="link-effect-2" id="link-effect-2">
        <a href="add-student"> <span data-hover="Добавить">Добавить студента</span></a>
        <a href="student-del" onclick="deleteStudents()"> <span data-hover="Удалить">Удалить студента</span></a>
        <a href="#"> <span data-hover="Модифицировать">Модифицировать студента</span></a>
        <a href="#"> <span data-hover="Просмотр">Просмотр успеваемости студента</span></a>
        <input type="submit" onclick="deleteStudents()" value="delete">
    </nav>
</section>

<%--<a href="#" onclick="deleteStudents()">Удалить студента</a>--%>


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
            <td><input type="checkbox" id="${student.id}"></td>
            <td>${student.first_name}</td>
            <td>${student.last_name}</td>
            <td>${student.group}</td>
            <td>${student.date}</td>
        </tr>
    </c:forEach>
</table>

