package com.example.student_junit_demo.service;

import java.util.List;

import com.example.student_junit_demo.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);

	public Student getStudentById(int sid);

	public List<Student> getAllStudents();

	public Student updateStudent(Student student, int sid);

	public void deleteStudent(int sid);

}
