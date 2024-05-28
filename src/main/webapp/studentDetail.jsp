<%--
  Created by IntelliJ IDEA.
  User: bairimengchang
  Date: 2024/5/14
  Time: 下午3:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑学生界面</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript">
        /*页面加载完成*/
        $(function (){
            getAllCla();
            showImg();
        });
        function getAllCla() {
            $.ajax({
                url:"${pageContext.request.contextPath}/ClassController/getAllCla",
                type:"get",
                success:function (data){
                    var option;
                    //获取班级id
                    var cid = $("#cla").val()

                    console.log(data)
                    //遍历集合
                    $(data).each(function (){
                        //判断所有班级中哪个是所在班级
                        if (this.cid == cid){
                            option = $("<option value='"+this.cid+"' selected>"+this.cname+"</option>")
                        }else {
                            option = $("<option value='"+this.cid+"'>"+this.cname+"</option>")
                        }
                        $("#cid").append(option)
                    })
                },error:function (){
                    alert("异步刷新失败")
                }
            })
        }
        //图片预览方法
        function showImg() {
            var stuImg = document.getElementById("stuImg")
            //图片对象
            var img = document.getElementById("img")
            //绑定一个改变事件
            stuImg.onchange = function () {
                //创建文件输入流对象
                var reader = new FileReader();
                //上传的文件保存在fileList中
                var file = this.files[0];
                //使用输入流读取文件
                reader.readAsDataURL(file);
                //读完图片把它放到src中
                reader.onload = function () {
                    //读取到的文件路径赋值给图片src属性
                    img.src = reader.result;
                }
            }
        }
    </script>
</head>
<body>
<%--<h1>${student}</h1>--%>
<fieldset>
    <legend>编辑学生信息</legend>
    <form action="${pageContext.request.contextPath}/StudentController/updateStu" method="post" enctype="multipart/form-data">
        <input type="hidden" name="stuNo" value="${student.stuNo}">
        <p>
            <label for="stuImg">证件照片</label>
            <img id="img" src="${pageContext.request.contextPath}/images/${student.stuImg}" alt="无照片" width="50px" height="50px"/>
            <input type="file" name="myFile" id="stuImg">
        </p>
        <p>
            <label for="stuName">姓名：</label>
            <input type="text" name="stuName" id="stuName" required value="${student.stuName}" placeholder="请输入学生的姓名">
        </p>
        <p>
            <label for="stuAge">年龄</label>
            <input type="number" name="stuAge" id="stuAge" required value="${student.stuAge}" placeholder="请输入学生的年龄">
        </p>
        <p>
            <label for="cid">所在班级</label>
            <input type="hidden" id="cla" value="${student.cla.cid}">
            <select id="cid" name="cla.cid"  required>
                <%--班级的全查--%>

            </select>
        </p>
        <p>
            <button type="submit">编辑</button>&nbsp;&nbsp;<button type="button" onclick="history.back()">返回上一级</button>
        </p>
    </form>
</fieldset>
</body>
</html>
