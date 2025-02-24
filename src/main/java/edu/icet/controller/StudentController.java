package edu.icet.controller;

import edu.icet.dto.Student;
import edu.icet.service.impl.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {

    @Autowired
    final StudentServiceImpl service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
        System.out.println(student);
    }

    @GetMapping("/get-all")
    public List<Student> getAll(){
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudent(@PathVariable Long id){
        service.deleteStudent(id);
    }

    @PutMapping("/update-student")
    public void updateStudent(@RequestBody Student student){
        service.updateStudent(student);
    }

    @GetMapping("/search-by-id/{id}")
    public Student searchById(@PathVariable Long id){
        return service.searchById(id);
    }

    @GetMapping("/search-by-first-name/{firstname}")
    public List<Student> searchByFirstName(@PathVariable String firstname){
        return service.searchByFirstName(firstname);
    }

    @GetMapping("/search-by-last-name/{lastname}")
    public List<Student> searchByLastName(@PathVariable String lastname){
        return service.searchByLastName(lastname);
    }

    @GetMapping("/search-by-email/{email}")
    public List<Student> searchByEmail(@PathVariable String email){
        return service.searchByEmail(email);
    }

}
