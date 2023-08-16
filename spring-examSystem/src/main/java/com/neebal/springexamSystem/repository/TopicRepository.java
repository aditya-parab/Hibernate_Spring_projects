package com.neebal.springexamSystem.repository;

import com.neebal.springexamSystem.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic,Long> {
}
