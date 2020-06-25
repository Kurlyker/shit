package ua.curs.work.repositoryes;


import org.springframework.data.mongodb.repository.MongoRepository;
import ua.curs.work.entities.News;


public interface NewsRepository extends MongoRepository<News, String> {

}
