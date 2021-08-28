package com.example.HelloSpringBoot.repository;

import com.example.HelloSpringBoot.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Post, Integer> {
}
