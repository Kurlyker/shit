package ua.curs.work.repositoryes;


import org.springframework.data.mongodb.repository.MongoRepository;
import ua.curs.work.entities.ComfortClass;

public interface ComfortClassRepository extends MongoRepository<ComfortClass, String> {



}
