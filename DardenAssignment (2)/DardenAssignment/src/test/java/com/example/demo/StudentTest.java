package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
@DataMongoTest
public class StudentTest {
	
	@Autowired
    private StudentRepository studentRepository;

    @Test
    public void testSaveStudent() {
        Student student = new Student();
        student.setName("Ampolu Bhavani");
        student.setAge(22);
        student.setSalary(30000.0);

        Student savedStudent = studentRepository.save(student);

        assertNotNull(savedStudent.getAge());
        assertEquals("Ampolu Bhavani", savedStudent.getName());
        assertEquals(22, savedStudent.getAge());
        assertEquals(30000.0, savedStudent.getSalary(), 0.001);
    }

}
