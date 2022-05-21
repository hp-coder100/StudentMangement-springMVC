package com.hemant.studentmanagement.service;

import java.util.List;

import com.hemant.studentmanagement.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudent();

	Student saveStudent(Student student);

	Student updateStudent(Student existingStudent);

	Student getStudentById(Long id);

	void deleteStudent(Student student);
}
