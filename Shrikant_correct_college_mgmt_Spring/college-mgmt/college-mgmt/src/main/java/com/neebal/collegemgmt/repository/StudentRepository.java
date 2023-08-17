package com.neebal.collegemgmt.repository;

import com.neebal.collegemgmt.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
