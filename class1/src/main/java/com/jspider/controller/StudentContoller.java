package com.jspider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.dto.StudentRequest;
import com.jspider.entity.Student;
import com.jspider.service.StudentService;
import com.jspider.util.ResponseStructure;

@RestController
public class StudentContoller {
	@Autowired
	private StudentService service;

//	@PostMapping("/saveme")
//	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
//		return service.saveStudent(student);
//	}
	@PostMapping("/saveme")
	public ResponseEntity<ResponseStructure<Student>> save(@RequestBody StudentRequest s){
		
		return service.saveStudent(s);
	}

	@PutMapping("/updateme")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @RequestParam int studentId) {
		return service.updateStudent(student, studentId);
	}

	@DeleteMapping("/removerecord")
	public ResponseEntity<Student> delete(@RequestParam int studentId) {
		return service.deleteStudent(studentId);
	}
    
	@GetMapping("/fetchme")
	public  ResponseEntity<List<Student>> findStudentById() {
		  List<Student> st= service.findAllStudents();
		return ResponseEntity.ok(st);
	}
	
	@GetMapping("/findaddress/{studentAddress}")
    public ResponseEntity<ResponseStructure<Student>> findBystudentAddress(@PathVariable String studentAddress){
	
		return service.findByAddress(studentAddress);
	}
	
	@GetMapping("/findgrade")
	public ResponseEntity<ResponseStructure<Student>> findByStudentGrade(@RequestParam String studentGradeString) {
		
		return service.findByGrade(studentGradeString);
	}
	
}
