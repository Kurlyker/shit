package ua.curs.work.services.news.impls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.curs.work.entities.News;
import ua.curs.work.repositoryes.NewsRepository;
import ua.curs.work.services.news.interfaces.iNewsService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NewsServiceImpl implements iNewsService {


    @Autowired
    NewsRepository repository;

    @PostConstruct
    void init(){
    }

    @Override
    public News save(News news) {
        return repository.save(news);
    }

    @Override
    public News get(String id) { return repository.findById(id).orElse(null);}

    @Override
    public List<News> getAll() { return repository.findAll(); }

    @Override
    public News edit(News news) {
        return repository.save(news);
    }

    @Override
    public News delete(String id) {
        News news = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return null;
    }



}
