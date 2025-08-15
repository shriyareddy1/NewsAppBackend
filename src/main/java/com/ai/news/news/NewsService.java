package com.ai.news.news;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
	@Autowired
	private NewsRepository repository;
	public NewsItem createNews(NewsItem news) {
        return repository.save(news);
    }

    public List<NewsItem> getAllNews() {
        return repository.findAll();
    }

    public Optional<NewsItem> getNewsById(Long id) {
        return repository.findById(id);
    }

    public void deleteNews(Long id) {
        repository.deleteById(id);
    }
    
    public List<NewsItem> searchByTitle(String query) {
        return repository.findByTitleContainingIgnoreCase(query);
    }

    public List<NewsItem> filterByDate(LocalDate query) {
        return repository.findByPublishedDate(query);
    }
	
}
