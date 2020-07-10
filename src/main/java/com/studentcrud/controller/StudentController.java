package com.studentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentcrud.model.Student;
import com.studentcrud.repository.StudentJpaRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentJpaRepository studentJpaRepository;

	@GetMapping("/all")
	public List<Student> findAll() {
		return studentJpaRepository.findAll();
	}

	@GetMapping("/{name}")
	public Student findByName(@PathVariable final String name) {
		return studentJpaRepository.findByName(name);
	}

	@PostMapping(value = "/load")
	public Student load(@RequestBody final Student student) {
		studentJpaRepository.save(student);
		return studentJpaRepository.findByName(student.getName());
	}

	@PutMapping("/update")
	public Student update(@RequestBody final Student student) {
		return studentJpaRepository.save(student);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		studentJpaRepository.deleteById(id);
	}

}
