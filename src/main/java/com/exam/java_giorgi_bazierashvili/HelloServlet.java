package com.exam.java_giorgi_bazierashvili;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.exam.java_giorgi_bazierashvili.DAO.Student;
import com.exam.java_giorgi_bazierashvili.database.MySqlConnection;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

import static com.exam.java_giorgi_bazierashvili.database.MySqlConnection.insertNewStudent;
import static java.lang.System.out;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        List<Student> stdList = MySqlConnection.getAllStudents();
        for (Student s: stdList){
            out.println("<h2>STUDENT: " +s + "</h1>");
        }

        out.println("<h1>CREATED STUDENT: "  + "</h1>");
        out.println("</body></html>");


    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = new Student();
        student.setFirstName(request.getParameter("studentName"));
        student.setLastName(request.getParameter("studentLastName"));
        student.setMajor(request.getParameter("studentMajor"));
        student.setAddress(request.getParameter("studentAddress"));
        student.setCity(request.getParameter("studentCity"));
        insertNewStudent(student);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>CREATED STUDENT: " + student + "</h1>");
        out.println("</body></html>");


    }


    public void destroy() {

    }


}