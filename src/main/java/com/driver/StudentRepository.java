package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {
    private HashMap<String,Student>studentMap;
    private HashMap<String,Teacher>teacherMap;
    private HashMap<String, List<String>> teacherStudentMap;

    public StudentRepository() {
        this.studentMap = new HashMap<String,Student>();
        this.teacherMap=new HashMap<String,Teacher>();
        this.teacherStudentMap=new HashMap<String,List<String>>();
    }

    public HashMap<String, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(HashMap<String, Student> studentMap) {
        this.studentMap = studentMap;
    }

    public HashMap<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(HashMap<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public HashMap<String, List<String>> getTeacherStudentMap() {
        return teacherStudentMap;
    }

    public void setTeacherStudentMap(HashMap<String, List<String>> teacherStudentMap) {
        this.teacherStudentMap = teacherStudentMap;
    }

    public void addStudent(Student student){
        studentMap.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String studentName, String teacherName){
        List<String> studentsList = new ArrayList<>();
        if(teacherStudentMap.containsKey(teacherName)){
            studentsList = teacherStudentMap.get(teacherName);
            studentsList.add(studentName);
            teacherStudentMap.put(teacherName, studentsList);
        }
        else{
            studentsList.add(studentName);
            teacherStudentMap.put(teacherName,studentsList);
        }
    }
    public Student getStudentByName(String studentName){
        for(String sName : studentMap.keySet()){
            if(sName.equals(studentName)){
                return studentMap.get(sName);
            }
        }
        return null;
    }
    public Teacher getTeacherByName(String teacherName){
        for(String tName : teacherMap.keySet()){
            if(tName.equals(teacherName)){
                return teacherMap.get(tName);
            }
        }
        return null;
    }
    public List<String> getStudentsByTeacherName(String teacherName){
        List<String> studentsList = new ArrayList<>();
        if(teacherStudentMap.containsKey(teacherName)){
            return teacherStudentMap.get(teacherName);
        }
        return studentsList;
    }
    public List<String> getAllStudents(){
        List<String> studentsList = new ArrayList<>();
        for(String sName : studentMap.keySet()){
            studentsList.add(sName);
        }
        return studentsList;
    }
    public void deleteTeacherByName(String teacherName){
        List<String> studentList = new ArrayList<>();
        if(teacherStudentMap.containsKey(teacherName)){
            studentList = teacherStudentMap.get(teacherName);
            for(String student : studentList){
                if(studentMap.containsKey(student)){
                    studentMap.remove(student);
                }
            }

            if(teacherMap.containsKey(teacherName)){
                teacherMap.remove(teacherName);
            }

            teacherStudentMap.remove(teacherName);
        }
    }

    public void deleteAllTeachers(){
        teacherMap = new HashMap<>();
        HashSet<String> studentSet = new HashSet<>();
        for(String tName : teacherStudentMap.keySet()){
            for(String sName : teacherStudentMap.get(tName)){
                studentSet.add(sName);
            }
        }

        for(String sName : studentSet){
            if(studentMap.containsKey(sName)){
                studentMap.remove(sName);
            }
        }

        teacherStudentMap = new HashMap<>();
    }
}
