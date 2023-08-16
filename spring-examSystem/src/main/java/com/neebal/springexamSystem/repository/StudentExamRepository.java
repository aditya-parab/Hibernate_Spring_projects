package com.neebal.springexamSystem.repository;

import com.neebal.springexamSystem.entities.StudentExam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentExamRepository extends JpaRepository<StudentExam,Long> {
}
