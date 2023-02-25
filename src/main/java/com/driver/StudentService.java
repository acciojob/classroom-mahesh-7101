package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentrepository;
    public void addStudent(Student student){
        studentrepository.addStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentrepository.addTeacher(teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        studentrepository.addStudentTeacherPair(name,name);
    }
    public Student getStudentByName(String student){
        return studentrepository.getStudentByName(student);
    }
    public Teacher getTeacherByName(String teacher){
        return studentrepository.getTeacherByName(teacher);
    }
    public List<String> getStudentByTeacherName(String teacher){
        return studentrepository.getStudentByTeacherName(teacher);
    }
    public List<String> getAllStudents(){
        return studentrepository.getAllStudents();
    }
    public void deleteTeacherByName(String teacher){
        studentrepository.deleteTeacherByName(teacher);
    }
    public void deleteAllTeachers(){
        studentrepository.deleteAllTeachers();
    }
}
