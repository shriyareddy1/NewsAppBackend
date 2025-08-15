package com.ai.news.news;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsItem, Long> {
	List<NewsItem> findByTitleContainingIgnoreCase(String title);
    List<NewsItem> findByPublishedDate(LocalDate publishedDate);
	
	
}
