package com.jspider.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jspider.dto.StudentRequest;
import com.jspider.entity.Student;
import com.jspider.util.ResponseStructure;

public interface StudentService {

	public ResponseEntity<ResponseStructure<Student>> saveStudent(StudentRequest student);
	
	public ResponseEntity<Student> updateStudent(Student student,int studentid);
	
	public ResponseEntity<Student> deleteStudent(int studentid);
	
	public ResponseEntity<Student> findStudentbyId(int studentid);
	
	public List<Student> findAllStudents();
	
	public  ResponseEntity<ResponseStructure<Student>> findByAddress(String studentAddres);
	
	public ResponseEntity<ResponseStructure<Student>> findByGrade(String studentGradeString);



}
