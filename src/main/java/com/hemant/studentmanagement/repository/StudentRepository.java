package com.hemant.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemant.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
