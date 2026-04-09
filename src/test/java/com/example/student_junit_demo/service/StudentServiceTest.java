package com.example.student_junit_demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.student_junit_demo.entity.Student;
import com.example.student_junit_demo.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
	@Mock
	private StudentRepository studentRepository;
	@InjectMocks
	private StudentServiceimpl studentServiceimpl;

	@Test
	public void testsaveStudent() {

		Student student = new Student(1, "prashanth", "vignan", "95618500712");
		when(studentRepository.save(student)).thenReturn(student);
		Student result = studentServiceimpl.saveStudent(student);
		assertEquals("prashanth", result.getSname());

	}

	@Test
	public void testgetStudentById() {
		Student student = new Student(1, "prashanth", "vignan", "95618500712");
		when(studentRepository.findById(1)).thenReturn(Optional.of(student));

		Student result = studentServiceimpl.getStudentById(1);
		assertEquals(1, result.getSid());

	}

	@Test
	void testGetAllStudents() {
		List<Student> list = Arrays.asList(new Student(1, "prashanth", "vignan", "95618500712"),
				new Student(2, "praveen", "vignan", "8179879043"));

		when(studentRepository.findAll()).thenReturn(list);

		List<Student> result = studentServiceimpl.getAllStudents();

		assertEquals(2, result.size());
	}

	@Test
	void testUpdateStudent() {
		Student existing = new Student(1, "prashanth", "vignan", "95618500712");
		Student updated = new Student(2, "praveen", "vignan", "8179879043");

		when(studentRepository.findById(1)).thenReturn(Optional.of(existing));
		when(studentRepository.save(any(Student.class))).thenReturn(updated);

		Student result = studentServiceimpl.updateStudent(updated, 1);

		assertEquals("praveen", result.getSname());
	}

	@Test
	void testDeleteStudent() {
		studentServiceimpl.deleteStudent(1);

		verify(studentRepository).deleteById(1);
	}

}
