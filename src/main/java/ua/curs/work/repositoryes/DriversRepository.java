package ua.curs.work.repositoryes;


import org.springframework.data.mongodb.repository.MongoRepository;
import ua.curs.work.entities.Driver;

public interface DriversRepository extends MongoRepository<Driver, String> {

}
