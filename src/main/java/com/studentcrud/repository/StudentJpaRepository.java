package com.studentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentcrud.model.Student;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Long> {

	Student findByName(String name);

}
