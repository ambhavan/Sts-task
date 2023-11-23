package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentByName(String name) {
        return studentRepository.findById(name);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(String name, Student updatedStudent) {
        Optional<Student> existingStudentOptional = studentRepository.findById(name);

        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setSalary(updatedStudent.getSalary());

            return Optional.of(studentRepository.save(existingStudent));
        } else {
            return Optional.empty(); 
        }
    }

    public void deleteStudent(String name) {
        studentRepository.deleteById(name);
    }

}
