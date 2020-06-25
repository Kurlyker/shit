package ua.curs.work.repositoryes;


import org.springframework.data.mongodb.repository.MongoRepository;
import ua.curs.work.entities.User;

public interface UserRepository extends MongoRepository<User, String> {
    
    User findByEmail(String email);
    
}
