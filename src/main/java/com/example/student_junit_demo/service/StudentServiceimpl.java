package com.example.student_junit_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student_junit_demo.entity.Student;
import com.example.student_junit_demo.repository.StudentRepository;

@Service
public class StudentServiceimpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		Student studentcreated = studentRepository.save(student);

		return studentcreated;
	}

	@Override
	public Student getStudentById(int sid) {
		Student studentgetting = studentRepository.findById(sid).orElse(null);
		return studentgetting;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> gettingstudents = studentRepository.findAll();
		return gettingstudents;
	}

	@Override
	public Student updateStudent(Student student, int sid) {
		Student studentupdate = studentRepository.findById(sid).orElse(null);
		if (student != null) {
			student.setSname(student.getSname());
			student.setSschool(student.getSschool());
			student.setSphone(student.getSphone());
			return studentRepository.save(studentupdate);
		}

		return null;
	}

	@Override
	public void deleteStudent(int sid) {

		studentRepository.deleteById(sid);

	}

}
