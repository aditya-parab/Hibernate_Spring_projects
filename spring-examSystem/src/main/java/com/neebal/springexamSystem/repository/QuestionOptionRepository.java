package com.neebal.springexamSystem.repository;

import com.neebal.springexamSystem.entities.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionOptionRepository extends JpaRepository<QuestionOption,Long> {
}
