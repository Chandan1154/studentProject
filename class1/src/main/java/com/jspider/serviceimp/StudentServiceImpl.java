package com.jspider.serviceimp;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jspider.dto.StudentRequest;
import com.jspider.dto.StudentResponse;
import com.jspider.entity.Student;
import com.jspider.exception.StudentNotFoundException;
import com.jspider.repository.StudentRepo;
import com.jspider.service.StudentService;
import com.jspider.util.ErrorStructure;
import com.jspider.util.ResponseStructure;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepo repo;
//
//	@Override
//	public ResponseEntity<Student> saveStudent(Student student) {
//		Student student2 = repo.save(student);
//
//		return new ResponseEntity<Student>(student2, HttpStatus.CREATED);
//	}

	@Override
	public ResponseEntity<Student> updateStudent(Student student, int studentId) {
		Optional<Student> optional = repo.findById(studentId);
		if (optional.isPresent()) {
			Student s1 = optional.get();
			student.setStudentId(s1.getStudentId());
			Student s3 = repo.save(student);
			return new ResponseEntity<Student>(s3, HttpStatus.OK);

		} else {
			return null;
		}
	}

	@Override
	public ResponseEntity<Student> deleteStudent(int studentId) {
		Optional<Student> st = repo.findById(studentId);
		if (st.isPresent()) {
			repo.deleteById(studentId);
			return new ResponseEntity<Student>(st.get(), HttpStatus.OK);
		} else {
			throw new StudentNotFoundException("Failed to delete the student!");
		}

	}

	@Override
	public ResponseEntity<Student> findStudentbyId(int studentid) {
		return null;
	}

	@Override
	public List<Student> findAllStudents() {
		return repo.findAll();
	}

	@Override
	public ResponseEntity<ResponseStructure<Student>> saveStudent(StudentRequest student) {
		Student s = new Student();
		s.setStudentName(student.getStudentName());
		s.setStudentAddress(student.getStudentAddress());
		s.setStudentGradeString(student.getStudentGradeString());

		Student s1 = repo.save(s);
		StudentResponse response = new StudentResponse();
		response.setStudentId(s1.getStudentId());
		response.setStudentName(s1.getStudentName());
		response.setStudentGradeString(s1.getStudentGradeString());

		ResponseStructure<Student> ss = new ResponseStructure<Student>();
		ss.setStatus(HttpStatus.CREATED.value());
		ss.setMessage("Student data save Successfully");
		ss.setData(s);

		return new ResponseEntity<ResponseStructure<Student>>(ss, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Student>> findByAddress(String studentAddress) {
		Student s1 = repo.findBystudentAddress(studentAddress);
		
		StudentResponse response = new StudentResponse();
		response.setStudentId(s1.getStudentId());
		response.setStudentName(s1.getStudentName());
		response.setStudentGradeString(s1.getStudentGradeString());
		
		ResponseStructure<Student> ss = new ResponseStructure<Student>();
		ss.setStatus(HttpStatus.CREATED.value());
		ss.setMessage("Student data save Successfully");
		ss.setData(s1);
  
		return new  ResponseEntity<ResponseStructure<Student>>( ss ,HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<ResponseStructure<Student>> findByGrade(String studentGradeString) {
        
		Student student=repo.findBystudentGradeString(studentGradeString);
		if(student!=null) {
			StudentResponse response= new StudentResponse();
			response.setStudentId(student.getStudentId());
			response.setStudentName(student.getStudentName());
			response.setStudentGradeString(student.getStudentGradeString());
			 
			ResponseStructure<Student> structure=new ResponseStructure<Student>();
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setMessage("Your Data successfully fetch by grade");
			structure.setData(student);
			return new ResponseEntity<ResponseStructure<Student>>(structure , HttpStatus.FOUND);
		}
		return null;
	}

}
