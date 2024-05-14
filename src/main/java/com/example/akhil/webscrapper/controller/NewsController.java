package com.example.akhil.webscrapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.akhil.webscrapper.services.ScrapperService;

@RestController
@RequestMapping("/api")
public class NewsController {
    @Autowired
    private ScrapperService scrapperService;

    @GetMapping("/scrape")
    public String scrapeNews() {
        scrapperService.scrapeBBCNews();
        return "Scraping BBC News Completed";
    }
}
