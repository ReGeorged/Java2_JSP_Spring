package com.exam.java_giorgi_bazierashvili;

import java.io.*;
import java.util.List;

import com.exam.java_giorgi_bazierashvili.bean.Student;
import com.exam.java_giorgi_bazierashvili.DAO.StudentDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static com.exam.java_giorgi_bazierashvili.DAO.StudentDao.insertNewStudent;

@WebServlet(name = "studentManagement", value = "/")
public class StudentServlet extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String dispatcherContext = request.getServletPath();
        RequestDispatcher requestDispatcher;

        switch (dispatcherContext) {
            case ("/"):
                requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
                break;
            case ("/add"):
                requestDispatcher = request.getRequestDispatcher("add.jsp");
                requestDispatcher.forward(request, response);
                break;
            case ("/getAll"):
                getAllUsers(request, response);
                requestDispatcher = request.getRequestDispatcher("getAll.jsp");
                requestDispatcher.forward(request, response);

        }


    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String servletContext = request.getServletPath();
        switch (servletContext) {
            case ("/studentManagement/add"):
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
                break;
            default:
                response.getWriter().println("ERROR");
        }


    }


    public void destroy() {

    }

    public static void getAllUsers(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.println("<html><body>");
        List<Student> stdList = StudentDao.getAllStudents();
        for (Student s : stdList) {
            out.println("<h2>STUDENT: " + s + "</h1>");
        }
        out.println("</body></html>");

    }


}