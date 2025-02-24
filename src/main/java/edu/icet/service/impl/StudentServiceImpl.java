package edu.icet.service.impl;

import edu.icet.dto.Student;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    final StudentRepository repository;
    final ModelMapper mapper;
    @Override
    public void addStudent(Student student) {
        repository.save(mapper.map(student, StudentEntity.class));
    }

    @Override
    public List<Student> getAll() {
        List<Student> studentList=new ArrayList<>();
        List<StudentEntity> all=repository.findAll();

        all.forEach(studentEntity -> {
            studentList.add(mapper.map(studentEntity, Student.class));
        });
        return studentList;
    }

    @Override
    public void deleteStudent(Long id) {
            repository.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {
        repository.save(mapper.map(student, StudentEntity.class));
    }

    @Override
    public Student searchById(Long id) {
        return mapper.map(repository.findById(id), Student.class);
    }

    @Override
    public List<Student> searchByFirstName(String firstname) {
        List<Student> studentList= new ArrayList<>();
        List<StudentEntity> byFirstName=repository.findByFirstName(firstname);

        byFirstName.forEach(studentEntity -> {
            studentList.add(mapper.map(studentEntity, Student.class));
        });
        return studentList;
    }

    @Override
    public List<Student> searchByLastName(String lastname) {
        List<Student> studentList= new ArrayList<>();
        List<StudentEntity> byLastName=repository.findByLastName(lastname);

        byLastName.forEach(studentEntity -> {
            studentList.add(mapper.map(studentEntity, Student.class));
        });
        return studentList;
    }

    @Override
    public List<Student> searchByEmail(String email) {
        List<Student> studentList=new ArrayList<>();
        List<StudentEntity> byEmail=repository.findByEmail(email);

        byEmail.forEach(studentEntity -> {
            studentList.add(mapper.map(studentEntity, Student.class));
        });
        return studentList;
    }
}
