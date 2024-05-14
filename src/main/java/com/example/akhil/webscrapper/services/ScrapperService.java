package com.example.akhil.webscrapper.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.example.akhil.webscrapper.model.News;
import com.example.akhil.webscrapper.repository.NewsRepository;

@Service
public class ScrapperService {

    @Autowired
     private NewsRepository newsRepository;

    public void scrapeBBCNews() {
        String url = "http://books.toscrape.com/";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements newsHeadlines = doc.select(".product_pod");

            List<News> newsArticle = new ArrayList<>();
            for (Element headline : newsHeadlines) {
                String title = headline.select("h3 > a").text();
                News news = new News();
                news.setTitle(title);
                news.setCreatedAt(LocalDateTime.now());
                newsArticle.add(news);
                System.out.println(title);
            }

            newsRepository.saveAll(newsArticle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
