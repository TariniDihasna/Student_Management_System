package edu.icet.service;

import edu.icet.dto.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> getAll();
    void deleteStudent(Long id);
    void updateStudent(Student student);
    Student searchById(Long id);
    List<Student> searchByFirstName(String firstname);
    List<Student> searchByLastName(String lastname);
    List<Student> searchByEmail(String email);
}
