package com.exam.assignment.DAO;

import com.exam.assignment.bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {
    public static Connection createMysqlConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exams?useSSL=false", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return con;

    }


    public static void insertNewStudent(Student student) {
        Connection myConnection = createMysqlConnection();
        String insertNewStudentQuery;
        try {
            insertNewStudentQuery = "INSERT INTO exams.Students (FirstName,LastName,Major,Address,City) values(?,?,?,?,?);";
            System.out.println(insertNewStudentQuery);
            PreparedStatement preparedStatement = myConnection.prepareStatement(insertNewStudentQuery);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getMajor());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getCity());
            preparedStatement.executeUpdate();

            myConnection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try {
            Connection mySqlConnection = createMysqlConnection();
            String query = "SELECT * FROM exams.Students";

            Statement statement = mySqlConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Student student = new Student();
                System.out.println(resultSet.getInt(1));
                student.setId(resultSet.getInt(1));
                student.setFirstName(resultSet.getString(2));
                student.setLastName(resultSet.getString(3));
                student.setMajor(resultSet.getString(4));
                student.setAddress(resultSet.getString(5));
                student.setCity(resultSet.getString(6));
                studentList.add(student);

            }
            return studentList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}


