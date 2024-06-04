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
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
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
        $(function (){
            getAllCla();
        });
        function getAllCla() {
            $.ajax({
                url:"${pageContext.request.contextPath}/ClassController/getAllCla",
                type:"get",
                success:function (data){
                    //获取学生所在的班级id
                    var cid = $("#cla").val();
                    $(data).each(function (){
                        var option;
                        if (this.cid == cid){
                            option = $("<option value='"+this.cid+"'selected>"+this.cname+"</option>");
                        }else{
                            option = $("<option value='"+this.cid+"'>"+this.cname+"</option>");
                        }
                        $("#cid").append(option);
                    })
                },error:function (){
                    alert("异步刷新失败")
                }
            })
        }
    </script>
</head>
<body>
<h1>学生列表界面</h1>
<h1>欢迎${uname}进入</h1>

<form action="${pageContext.request.contextPath}/StudentController/getStuByPage/1" method="get">
    <label>学号:</label><input type="text" name="stuNo" value="${stuNo}">
    <p>
        <label for="stuName">姓名:</label>
        <input type="text" name="stuName" id="stuName" value="${stuName}">
    </p>
    <p>
        <label for="stuAge">年龄:</label>
        <input type="number" name="minAge" id="stuAge" value="${minAge}">到
        <input type="number" name="maxAge" id="maxAge" value="${maxAge}">
    </p>
    <p>
        <label for="cid">所在班级:</label>
        <input type="hidden" id="cla" value="${cla}">
        <select name="cla" id="cid">
            <%--所选班级信息:班级的全查--%>
            <option value="-1">--请选择班级--</option>
        </select>
    </p>
    <p>
        <input type="submit" value="搜索">
    </p>
</form>

<button style="background-color: aqua; font-size: 20px;margin-top: 20px;margin-bottom: 20px"
        onclick="window.location.href='${pageContext.request.contextPath}/addStu.jsp'">新增学生</button>

<table border="3px">
    <tr>
        <th>学生照片</th>
        <th>学生编号</th>
        <th>学生姓名</th>
        <th>学生年龄</th>
        <th>班级</th>
        <th>简介</th>
        <th>操作</th>
        <%--        <th>学生班级</th>--%>
    </tr>

    <c:forEach items="${page.list}" var="student">
        <tr>
            <td><img src="${pageContext.request.contextPath}/images/${student.stuImg}" alt="无照片" width="50px" height="50px"/></td>
            <td>${student.stuNo}</td>
            <td>${student.stuName}</td>
            <td>${student.stuAge}</td>
            <td>${student.cla.cname}</td>
            <td>${student.cla.ccontent}</td>
            <td>
                <a href="javascript:void(0)" onclick="delStu(${student.stuNo})">删除</a>
                <a href="javascript:void(0)" onclick="editStu(${student.stuNo})">编辑</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7">
            <button onclick="firstPage()">首页</button>
            <button onclick="upPage()">上一页</button>
            ${page.pageNum}/${page.pages}
            <button onclick="nextPage()">下一页</button>
            <button onclick="lastPage()">尾页</button>
        </td>
    </tr>
</table>

<script>
    //首页
    function firstPage() {
        if (${page.isFirstPage}){
            alert("已经是第一页")
        }else {
            location.href="${pageContext.request.contextPath}/StudentController/getStuByPage/1?stuNo=${stuNo}&stuName=${stuName}&minAge=${minAge}&maxAge=${maxAge}&cla=${cla}"
        }
    }
    //上一页
    function upPage() {
        if (${page.isFirstPage}){
            alert("已经是第一页")
        }else {
            location.href="${pageContext.request.contextPath}/StudentController/getStuByPage/${page.prePage}?stuNo=${stuNo}&stuName=${stuName}&minAge=${minAge}&maxAge=${maxAge}&cla=${cla}"
        }
    }
    //下一页
    function nextPage() {
        if (${page.isLastPage}){
            alert("已经是最后一页")
        }else {
            location.href="${pageContext.request.contextPath}/StudentController/getStuByPage/${page.nextPage}?stuNo=${stuNo}&stuName=${stuName}&minAge=${minAge}&maxAge=${maxAge}&cla=${cla}"
        }
    }
    //尾页
    function lastPage() {
        if (${page.isLastPage}){
            alert("已经是最后一页")
        }else {
            location.href="${pageContext.request.contextPath}/StudentController/getStuByPage/${page.pages}?stuNo=${stuNo}&stuName=${stuName}&minAge=${minAge}&maxAge=${maxAge}&cla=${cla}"
        }
    }
</script>

</body>
</html>
