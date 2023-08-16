package com.neebal.springexamSystem.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="studententities")
public class StudentEntity {
    public StudentEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StudentExam> getExamsEnrolled() {
        return examsEnrolled;
    }

    public void setExamsEnrolled(Set<StudentExam> examsEnrolled) {
        this.examsEnrolled = examsEnrolled;
    }

    @OneToMany(mappedBy = "studentEntity")
    private Set<StudentExam> examsEnrolled = new HashSet<>();
}
