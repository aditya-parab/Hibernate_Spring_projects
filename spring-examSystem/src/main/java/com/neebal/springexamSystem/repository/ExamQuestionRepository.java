package com.neebal.springexamSystem.repository;

import com.neebal.springexamSystem.entities.ExamQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamQuestionRepository extends JpaRepository<ExamQuestion,Long> {
}
