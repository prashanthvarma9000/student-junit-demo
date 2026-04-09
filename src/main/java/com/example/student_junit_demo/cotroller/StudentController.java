package com.example.student_junit_demo.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_junit_demo.entity.Student;
import com.example.student_junit_demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}

	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable("id") int sid) {
		return studentService.getStudentById(sid);
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PutMapping("/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int sid) {
		return studentService.updateStudent(student, sid);
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable("id") int sid) {
		studentService.deleteStudent(sid);
		return "Student deleted successfully";
	}

}
