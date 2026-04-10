package com.example.student_junit_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student_junit_demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public Student findBySname(String sname);
	public Student findBySemail(String semail);

	public Student findBySphone(String sphone);

	public Student findBySaddress(String saddress);

	public Student findBySage(int sage);
}
