package com.neebal.springexamSystem.services;

import com.neebal.springexamSystem.entities.Exam;
import com.neebal.springexamSystem.entities.StudentEntity;
import com.neebal.springexamSystem.entities.StudentExam;
import com.neebal.springexamSystem.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Service
@SessionAttributes("student")
public class MasterDataService {

    StudentEntity studentEntity;
    StudentExam studentExam;

    @Autowired
    ExamRepository examRepository;

    MasterDataService(){
        studentEntity=new StudentEntity();
        studentExam = new StudentExam();
    }


    public StudentEntity setStudentName(String name){

        studentEntity.setName(name);
        return studentEntity;
    }

    public StudentExam setStudent(@ModelAttribute("student") StudentEntity student){
        studentExam.setStudentEntity(student);
//        System.out.println(student.getName());
        return studentExam;
    }

    public List<Object[]> getAllExams(){
//        List<Object[]> examIdsAndTitles = examRepository.findAllExamIdsAndTitles();


//        for (Object[] examData : examIdsAndTitles) {
//            Long examId = (Long) examData[0];
//            String examTitle = (String) examData[1];
//
//
//            System.out.println("Exam ID: " + examId + ", Title: " + examTitle);
//
//        }
//        return examIdsAndTitles;

    return null;
    }
}
