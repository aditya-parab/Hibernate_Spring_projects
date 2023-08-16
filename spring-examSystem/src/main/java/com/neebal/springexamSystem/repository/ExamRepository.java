package com.neebal.springexamSystem.repository;

import com.neebal.springexamSystem.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam,Long> {

//    @Query("SELECT e.id, e.title FROM Exam e")
//    List<Object[]> findAllExamIdsAndTitles();

    // List<Exam> findAll();
}
