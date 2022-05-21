package com.hemant.studentmanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hemant.studentmanagement.entity.Student;
import com.hemant.studentmanagement.repository.StudentRepository;
import com.hemant.studentmanagement.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		
		return studentRepository.save(student);
		
	}


	@Override
	public Student updateStudent(Student existingStudent) {
		// TODO Auto-generated method stub
		return studentRepository.save(existingStudent);
		
	}


	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).get();
	}


	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepository.delete(student);
	}

}
