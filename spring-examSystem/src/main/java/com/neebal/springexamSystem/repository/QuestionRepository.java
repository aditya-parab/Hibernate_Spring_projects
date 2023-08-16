package com.neebal.springexamSystem.repository;

import com.neebal.springexamSystem.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
