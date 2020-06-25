package ua.curs.work.services.news.interfaces;





import ua.curs.work.entities.News;

import java.util.List;

public interface iNewsService {
    News save(News news);
    News get(String id);
    List<News> getAll();
    News edit(News news);
    News delete(String id);


}
