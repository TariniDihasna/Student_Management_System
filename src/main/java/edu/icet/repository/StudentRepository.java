package edu.icet.repository;

import edu.icet.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    List<StudentEntity> findByFirstName(String firstName);
    List<StudentEntity> findByLastName(String lastName);
    List<StudentEntity> findByEmail(String email);
}
