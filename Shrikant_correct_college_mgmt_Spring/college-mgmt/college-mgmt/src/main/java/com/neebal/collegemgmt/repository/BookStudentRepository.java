package com.neebal.collegemgmt.repository;

import com.neebal.collegemgmt.entities.Student;
import com.neebal.collegemgmt.entities.Book;
import com.neebal.collegemgmt.entities.BookStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStudentRepository extends JpaRepository<BookStudent, Long> {
    BookStudent findBookStudentByBookAndStudentAndReturnDateIsNull(
            Book book,
            Student student
    );
}
