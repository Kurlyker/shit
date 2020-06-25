package ua.curs.work.repositoryes;


import org.springframework.data.mongodb.repository.MongoRepository;
import ua.curs.work.entities.Bus;

public interface BusesRepository extends MongoRepository<Bus, String> {



}
