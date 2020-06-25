package ua.curs.work.repositoryes;


import org.springframework.data.mongodb.repository.MongoRepository;
import ua.curs.work.entities.PassangerClass;

public interface PassangerClassRepository extends MongoRepository<PassangerClass, String> {



}
