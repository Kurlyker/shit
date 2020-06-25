package ua.curs.work.repositoryes;


import org.springframework.data.mongodb.repository.MongoRepository;
import ua.curs.work.entities.Role;


public interface RoleRepository extends MongoRepository<Role, String> {
    
    Role findByRole(String role);
}
