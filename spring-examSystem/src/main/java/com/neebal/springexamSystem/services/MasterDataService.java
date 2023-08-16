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

    private StudentEntity studentEntity;
    private StudentExam studentExam;

    @Autowired
    private ExamRepository examRepository;


    public MasterDataService(){
        studentEntity=new StudentEntity();
        studentExam = new StudentExam();

        System.out.println("masterDataService constructor is being called");

    }


    public StudentEntity setStudentName(String name){

        studentEntity.setName(name);
        return studentEntity;
    }



    public List<Exam> getAllExams(){
            if(this.examRepository==null){
                System.out.println("examrepo is null");
            }
            List<Exam> exams = this.examRepository.findAll();
        exams
                .forEach(exam -> System.out.println("exam title"+exam.getTitle()));



    return exams;
    }
}
