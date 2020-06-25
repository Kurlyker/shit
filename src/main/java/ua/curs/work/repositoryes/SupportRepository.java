package ua.curs.work.repositoryes;


import org.springframework.data.mongodb.repository.MongoRepository;
import ua.curs.work.entities.Support;

import java.util.List;

public interface SupportRepository extends MongoRepository<Support, String> {

    List<Support> findByActive(Boolean active);

}
