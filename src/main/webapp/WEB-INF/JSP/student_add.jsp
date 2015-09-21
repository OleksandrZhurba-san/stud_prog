<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<h2>Заполните пожалуйста все поля </h2>
<br>

<form action="add-student" method="post">
    <ul>
        <li><input type="text" name="first_name" placeholder="Имя"/></li>
        <li><input type="text" name="second_name" placeholder="Фамилия"/></li>
        <li><input type="text" name="group" placeholder="Группа"/></li>
        <li><input type="text" id="datepicker" name="date" placeholder="Дата поступления"/></li>
        <li><input type="submit" value="Создать" id="create_button"></li>
    </ul>
</form>
