package com.neebal.springexamSystem.repository;

import com.neebal.springexamSystem.entities.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer,Long> {
}
