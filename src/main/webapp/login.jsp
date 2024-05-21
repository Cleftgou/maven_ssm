<%--
  Created by IntelliJ IDEA.
  User: bairimengchang
  Date: 2024/4/9
  Time: 下午2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<fieldset>
    <legend>欢迎登录学生管理系统!</legend>
    <form action="${pageContext.request.contextPath}/UserController/login" method="post">
        <p>
            <label>用户名：</label>
            <input type="text" name="uname" placeholder="请输入用户名" required><br>
        </p>
        <p>
            <label>密码：</label>
            <input type="password" name="upwd" placeholder="请输入密码" required><br>
        </p>
        <span style="color: red">${error}</span>
        <p>
            <button type="submit">登录</button>&nbsp;&nbsp;<button type="button">注册</button>
        </p>
    </form>
</fieldset>

</body>
</html>
