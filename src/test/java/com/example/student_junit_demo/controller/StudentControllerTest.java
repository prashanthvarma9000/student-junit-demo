package com.example.student_junit_demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.student_junit_demo.cotroller.StudentController;
import com.example.student_junit_demo.entity.Student;
import com.example.student_junit_demo.service.StudentService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;


@WebMvcTest(StudentController.class)
public class StudentControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	@Test
	void testSaveStudent() throws Exception {

		Student student = new Student(1, "Prashanth", "vignan", "9618500712");

		when(studentService.saveStudent(any(Student.class))).thenReturn(student);

		mockMvc.perform(post("/students").contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content("{\"sid\":1,\"sname\":\"Prashanth\"}")).andExpect(status().isOk())
				.andExpect(jsonPath("$.sname").value("Prashanth"));
	}

	@Test
	void testGetStudentById() throws Exception {

		Student student = new Student(1, "Prashanth", "vignan", "9618500712");

		when(studentService.getStudentById(1)).thenReturn(student);

		mockMvc.perform(get("/students/1")).andExpect(status().isOk()).andExpect(jsonPath("$.sid").value(1));
	}

	@Test
	void testGetAllStudents() throws Exception {

		List<Student> list = Arrays.asList(new Student(1, "Prashanth", "vignan", "9618500712"),
				new Student(2, "praveen", "vignan", "8179879043"));

		when(studentService.getAllStudents()).thenReturn(list);

		mockMvc.perform(get("/students")).andExpect(status().isOk()).andExpect(jsonPath("$.size()").value(2));
	}

	@Test
	void testUpdateStudent() throws Exception {

		Student student = new Student(1, "Prashanth", "vignan", "9618500712");

		when(studentService.updateStudent(any(Student.class), anyInt())).thenReturn(student);

		mockMvc.perform(put("/students/1").contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content("{\"sid\":1,\"sname\":\"Updated\"}")).andExpect(status().isOk())
				.andExpect(jsonPath("$.sname").value("Updated"));
	}

	@Test
	void testDeleteStudent() throws Exception {

		doNothing().when(studentService).deleteStudent(1);

		mockMvc.perform(delete("/students/1")).andExpect(status().isOk())
				.andExpect(content().string("Student deleted successfully"));
	}

}
