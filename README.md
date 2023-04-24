#### log in to mysql ,create  schema named exams: create table named students in it:
###
#### CREATE DATABASE exams;
#### USE exams;
#### CREATE TABLE Students (id int NOT NULL AUTO_INCREMENT,FirstName varchar(255), LastName varchar(255),Major varchar(255), Address varchar(255),City varchar(255), PRIMARY KEY (id))
###
#### you need to configure sql connection in com.exam.assignment.DAO.StudentDao
### jdk17; glassfish 6.2.5 : configure port in glassfish>domains>domain1>config>domain.xml