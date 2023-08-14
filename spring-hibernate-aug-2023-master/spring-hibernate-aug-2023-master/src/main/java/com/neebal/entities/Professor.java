package com.neebal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "professors")
public class Professor extends Person {

    @Column(nullable = true, length = 20)
    private String qualification;

    public Professor() {}

    public Professor(String name, Character gender, String qualification) {
        super(name, gender);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "qualification='" + qualification + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
