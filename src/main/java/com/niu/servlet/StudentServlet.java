//package com.niu.servlet;
//
//import com.niu.pojo.Student;
//import com.niu.service.StudentService;
//import com.niu.service.impl.StudentServiceImpl;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.io.IOException;
//import java.util.List;
//
///**
// * @author bairimengchang
// * @version 1.0
// * @project maven_ssm
// * @description
// * @date 2024/4/9 15:05:26
// */
//@WebServlet("/student")
//public class StudentServlet extends HttpServlet {
//
//    ApplicationContext context = new ClassPathXmlApplicationContext("mybatis-spring.xml");
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        StudentService studentService = context.getBean("ss", StudentService.class);
//        req.setCharacterEncoding("utf-8");
//        String contextPath = req.getContextPath();
//        String action = req.getParameter("action");
//
//        if ("selectAll".equals(action)) {
//            //全查
//            List<Student> students = studentService.getAllStu();
//            req.setAttribute("students", students);
//            //转发
//            req.getRequestDispatcher("/student.jsp").forward(req, resp);
//        }else if ("del".equals(action)) {
//            String stuNo = req.getParameter("stuNo");
//            boolean b = studentService.delStu(Integer.parseInt(stuNo));
//            if (b){
//                //删除成功
//                //重定向
//                resp.sendRedirect(contextPath + "/student?action=selectAll");
//            }
//            else {
//                System.out.println("系统出现问题");
//            }
//        }
//    }
//}
