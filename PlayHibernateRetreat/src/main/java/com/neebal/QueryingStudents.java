package com.neebal;

import com.neebal.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class QueryingStudents {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try(Session session = sessionFactory.openSession()){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

            Root<Student> root = cq.from(Student.class);

            cq
                    .multiselect(root.get("gender"),    //have to select the column that is being grouped by so we select gender
                            cb.count(root.get("gender")))

                    .groupBy(root.get("gender"));

            List<Object[]> rows = session
                    .createQuery(cq)
                    .getResultList();

            for(Object[] row : rows){
                System.out.println(row[0]+" , "+row[1]);
            }



        }
    }
}
