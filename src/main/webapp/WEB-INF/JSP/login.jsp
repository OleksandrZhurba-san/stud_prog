<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <title></title>
</head>
<body>
<div id="title"><h1> Система управления студентами и их успеваемостью</h1></div>
<div id="login">
  <%--<div id="triangle"></div>--%>
   <form action="login" method="post">
    <input type="login" name="login" placeholder="Login" />
    <input type="password" name="password" placeholder="Password" />
    <input type="submit" value="Log in" />
      <select name="role" id="opening_list">
          <option value="1">Администратор</option>
          <option value="2">Студент</option>
          <option value="3">Преподаватель</option>>
      </select>
  </form>
</div>
</body>
</html>
