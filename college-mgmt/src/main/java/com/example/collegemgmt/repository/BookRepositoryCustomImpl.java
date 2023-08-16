package com.example.collegemgmt.repository;

import com.example.collegemgmt.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryCustomImpl implements BookRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Object[]> groupByPriceCountBooks() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Object[].class);

        Root<Book> root = cq.from(Book.class);
        cq
                .multiselect(
                        root.get("price"),
                        cb.count(root.get("price"))
                )
                .groupBy(
                        root.get("price")
                );
        return em.createQuery(cq).getResultList();

    }
}
