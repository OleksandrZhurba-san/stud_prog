<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <li class="discipline"><a href="discipline">Дисцыплины</a></li>
    <li class="terms"><a href="terms">Семестры</a></li>
    <li class="logout"><a href="logout">Logout</a></li>
  </ul>
  <h2>Заполните пожалуйста все поля </h2>
  <br>
  <form action="add_discipline" method="post">
    <ul>
      <li><input type="text" name="discipline" placeholder="Дисциплина"/></li>
      <li><input type="submit" value="Создать" id="create_button" ></li>
    </ul>
  </form>
</div>
</body>
</html>
