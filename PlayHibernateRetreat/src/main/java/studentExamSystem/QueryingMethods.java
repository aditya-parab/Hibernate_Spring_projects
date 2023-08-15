package studentExamSystem;

import com.neebal.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import studentExamSystem.entities.Exam;
import studentExamSystem.entities.StudentEntity;
import studentExamSystem.entities.Topic;

import javax.persistence.Query;
import java.util.List;

public class QueryingMethods {

    public static void getStudentsWhereMarksGreaterThan5(Session session){
        String hql = "select se.studentEntity from StudentExam se where se.marksObtained >= 5";
        List<StudentEntity> studentsWithMarks = session
                .createQuery(hql, StudentEntity.class)
                .getResultList();

        for (StudentEntity student : studentsWithMarks) {
            System.out.println("Student Name: " + student.getName());
        }
    }
    public static void getStudentsMarksDesc(Session session){
        String hql = "select se.studentEntity, se.marksObtained from StudentExam se order by se.marksObtained desc";
        List<Object[]> results  = session.createQuery(hql, Object[].class).getResultList();

        for (Object[] result : results) {
            StudentEntity studentEntity = (StudentEntity) result[0];
            int marksObtained = (int) result[1];

            System.out.println("Student Name: " + studentEntity.getName());
            System.out.println("Marks Obtained: " + marksObtained);
            System.out.println();
        }

    }

    public static void getExamsAndTopics(Session session){
        String hql = "select distinct e, t " +
                "from Exam e " +
                "join e.examQuestions eq " +
                "join eq.question q " +
                "join q.topic t";

        List<Object[]> results  = session.createQuery(hql, Object[].class).getResultList();

        for (Object[] result : results) {
            Exam exam = (Exam) result[0];
            Topic topic = (Topic) result[1];

            System.out.print("Exam Title: " + exam.getTitle());
            System.out.println(", Topic Name: " + topic.getName());
            System.out.println();
        }
    }


    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            System.out.println("Students who scored more than or equal to 5 are:");
            getStudentsWhereMarksGreaterThan5(session);
            System.out.println("***************************************************");
            System.out.println("Students and their marks in desc order:");
            getStudentsMarksDesc(session);
            System.out.println("***************************************************");
            System.out.println("All Exams and their Topics:");
            getExamsAndTopics(session);
        }


    }
}
