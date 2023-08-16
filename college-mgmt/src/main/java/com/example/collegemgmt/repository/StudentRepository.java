package com.example.collegemgmt.repository;

import com.example.collegemgmt.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findStudentById(long id);

}
