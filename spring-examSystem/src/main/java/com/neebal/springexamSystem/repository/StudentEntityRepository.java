package com.neebal.springexamSystem.repository;

import com.neebal.springexamSystem.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEntityRepository extends JpaRepository<StudentEntity,Long> {
}
