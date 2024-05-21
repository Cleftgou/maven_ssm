//package com.niu.servlet;
//
//import com.niu.service.UserService;
//import com.niu.service.impl.UserServiceImpl;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.io.IOException;
//
///**
// * @author bairimengchang
// * @version 1.0
// * @project maven_ssm
// * @description
// * @date 2024/4/9 14:44:08
// */
//@WebServlet("/user")
//public class UserServlet extends HttpServlet {
//
//    ApplicationContext context = new ClassPathXmlApplicationContext("mybatis-spring.xml");
//
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        UserService userService = context.getBean("us", UserService.class);
//
//        req.setCharacterEncoding("utf-8");
//        String contextPath = req.getContextPath();
//        String action = req.getParameter("action");
//
//        if ("login".equals(action)) {
//            //登录
//            String uname = req.getParameter("uname");
//            String upwd = req.getParameter("upwd");
//            Boolean b = userService.login(uname, upwd);
//
//            //判断登录是否成功
//            if (b){
//                req.getSession().setAttribute("uname", uname);
//                //req.getRequestDispatcher("/bookInfoServlet?action=getPage").forward(req, resp);
//                System.out.println(uname);
//                //http://localhost:8080/maven/student?action=selectAll
//                //移除报错信息
//                req.getSession().removeAttribute("error");
//                //req.getRequestDispatcher("/student?action=selectAll").forward(req, resp);
//                //重定向
//                resp.sendRedirect(contextPath + "/student?action=selectAll");
//            }else {
//                //添加报错信息
//                req.getSession().setAttribute("error", "账号或密码错误");
//                resp.sendRedirect(contextPath+"/login.jsp");
//            }
//        }
//    }
//}
