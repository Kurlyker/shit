package ua.curs.work.repositoryes;


import org.springframework.data.mongodb.repository.MongoRepository;
import ua.curs.work.entities.City;


public interface CitiesRepository extends MongoRepository<City, String> {

}
