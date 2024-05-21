<%--
  Created by IntelliJ IDEA.
  User: bairimengchang
  Date: 2024/4/9
  Time: 下午3:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>学生列表</title>
    <script>
        function delStu(stuNo){
            var bo = confirm("是否删除：" + stuNo + "的学生？")
            if (bo){
                location.href="${pageContext.request.contextPath}/StudentController/delete/" + stuNo
                alert("删除成功");
            }
        }
        function editStu(stuNo){
            var bo = confirm("是否编辑：" + stuNo + "的学生？")
            if (bo){
                location.href="${pageContext.request.contextPath}/StudentController/edit/" + stuNo
            }
        }
    </script>
</head>
<body>
<h1>学生列表界面</h1>
<h1>欢迎${uname}进入</h1>

<button style="background-color: aqua; font-size: 20px;margin-top: 20px;margin-bottom: 20px"
        onclick="window.location.href='${pageContext.request.contextPath}/addStu.jsp'">新增学生</button>

<table border="3px">
    <tr>
        <th>学生图片</th>
        <th>学生编号</th>
        <th>学生姓名</th>
        <th>学生年龄</th>
        <th>班级</th>
        <th>简介</th>
        <th>操作</th>
<%--        <th>学生班级</th>--%>
    </tr>

    <c:forEach items="${students}" var="student">
        <tr>
            <td><img src="${pageContext.request.contextPath}/images/${student.stuImg}" alt="无照片" width="50px" height="50px"/></td>
            <td>${student.stuNo}</td>
            <td>${student.stuName}</td>
            <td>${student.stuAge}</td>
            <td>${student.cla.cid}</td>
            <td>${student.cla.ccontent}</td>
            <td>
                <a href="javascript:void(0)" onclick="delStu(${student.stuNo})">删除</a>
                <a href="javascript:void(0)" onclick="editStu(${student.stuNo})">编辑</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
