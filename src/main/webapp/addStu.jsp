<%--
  Created by IntelliJ IDEA.
  User: bairimengchang
  Date: 2024/5/21
  Time: 下午2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生录入</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript">
        /*页面加载完成*/
        $(function (){
           getAllCla();
        });
        function getAllCla() {
            $.ajax({
                url:"${pageContext.request.contextPath}/ClassController/getAllCla",
                type:"get",
                success:function (data){
                    console.log(data)
                    //遍历集合
                    $(data).each(function (){
                        var option = $("<option value='"+this.cid+"'>"+this.cname+"</option>")
                        $("#cid").append(option)
                    })
                },error:function (){
                    alert("异步刷新失败")
                }
            })
        }
    </script>
</head>
<body>
<fieldset>
    <legend>录入学生信息</legend>
    <form action="${pageContext.request.contextPath}/StudentController/addStu" method="post" enctype="multipart/form-data">
        <p>
            <label for="stuImg">证件照片</label>
            <input type="file" name="myFile" id="stuImg" required>
        </p>
        <p>
            <label for="stuName">姓名：</label>
            <input type="text" name="stuName" id="stuName" required placeholder="请输入学生的姓名">
        </p>
        <p>
            <label for="stuAge">年龄</label>
            <input type="number" name="stuAge" id="stuAge" required placeholder="请输入学生的年龄">
        </p>
        <p>
            <label for="cid">所在班级</label>
            <select id="cid" name="cla.cid" required>
                <%--班级的全查--%>

            </select>
        </p>
        <p>
            <button type="submit">录入</button>&nbsp;&nbsp;<button type="button" onclick="history.back()">返回上一级</button>
        </p>
    </form>
</fieldset>
</body>
</html>
