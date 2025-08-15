package com.ai.news.news;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news") //comes after 8080
public class NewsController {
	
      @Autowired
      private NewsRepository repository;
      @Autowired 
      private NewsService service;
      
      @PostMapping //creation of an object 
      public NewsItem createNews(@RequestBody NewsItem news) { 
    	  System.out.println("This API has been called.");
          return service.createNews(news);
      }
      
      @GetMapping
      public List<NewsItem> getAllNews() {
          return service.getAllNews();
      }

      @GetMapping("/{id}")
      public Optional<NewsItem> getNewsById(@PathVariable Long id) {
          return service.getNewsById(id);
      }

      @DeleteMapping("/{id}")
      public void deleteNews(@PathVariable Long id) {
          service.deleteNews(id);
      }
      
      @GetMapping("/search")
      public List<NewsItem> search(@RequestParam String query) {
          return service.searchByTitle(query);
      }
      
      
      @GetMapping("/search/date")
      public List<NewsItem>filterByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate query){
		return service.filterByDate(query);
    	  
      }
}
