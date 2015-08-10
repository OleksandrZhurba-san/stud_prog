<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <link href="resources/css/ui-lightness/jquery-ui-1.10.4.custom.css" rel="stylesheet">
    <script src="resources/js/jquery-1.10.2.js"></script>
    <script src="resources/js/jquery-ui-1.10.4.custom.js"></script>

    <script src="/resources/js/jquery.ui.datepicker-ru.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function(){
            $("#datepicker").datepicker({dateFormat: "yy-mm-dd"});
            $("#datepicker").datepicker();
        });
    </script>
    <title></title>
</head>

<body>
    <div id="title"><h1> Система управления студентами и их успеваемостью</h1></div>
    <div class="nav">
        <ul>
            <li class="home"><a href="students">Студенты</a></li>
            <li class="discipline"><a  href="discipline">Дисцыплины</a></li>
            <li class="terms"><a href="terms">Семестры</a></li>
            <li class="logout"><a href="logout">Logout</a> </li>
        </ul>
    </div>

        <h2>Заполните пожалуйста все поля </h2>
    <br>
    <form action="add_student" method="post">
    <ul>
        <li><input type="text" name="first_name" placeholder="Имя"/></li>
        <li><input type="text" name="second_name" placeholder="Фамилия"/></li>
        <li><input type="text" name="group" placeholder="Группа"/></li>
        <li><input type="text" id="datepicker" name="date" placeholder="Дата поступления"/></li>
        <li><input type="submit" value="Создать" id="create_button" ></li>
    </ul>
    </form>
</body>
</html>
