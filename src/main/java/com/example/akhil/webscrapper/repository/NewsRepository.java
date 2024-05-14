package com.example.akhil.webscrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.akhil.webscrapper.model.News;

public interface NewsRepository extends JpaRepository<News, Long> {
    
}