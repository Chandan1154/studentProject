package com.jspider.repository;

import com.jspider.entity.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	public Student  findBystudentAddress(String studentAddress);
	public Student findBystudentGradeString(String studentGradeString);

}
