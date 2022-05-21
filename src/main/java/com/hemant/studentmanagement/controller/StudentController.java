package com.hemant.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.hemant.studentmanagement.entity.Student;
import com.hemant.studentmanagement.service.StudentService;

@Controller
public class StudentController {
	
	
	private StudentService studentService;
	

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudent());
		return "students";
	}
	
	
	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	
	@PostMapping(value="/students")
	public String saveStudent(@ModelAttribute("student") Student  student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		
		model.addAttribute("student", studentService.getStudentById(id));
		return "update_student";
		
	}
	
	@PostMapping(value ="/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		Student existingStudent = studentService.getStudentById(id);
		
		existingStudent.setEmail(student.getEmail());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		
		studentService.updateStudent(existingStudent);
		
		return "redirect:/students";
	}
	
	
	@GetMapping("students/delete/{id}")
	public String deleteStudent(@PathVariable Long id, Model model) {
		Student student = studentService.getStudentById(id);
		studentService.deleteStudent(student);
		return "redirect:/students";
	}

	
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
}
