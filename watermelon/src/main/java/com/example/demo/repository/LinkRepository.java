package com.example.demo.repository;

import com.example.demo.data.LinkObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<LinkObject, Integer> {

    LinkObject findByKeyword(String keyword);
}
