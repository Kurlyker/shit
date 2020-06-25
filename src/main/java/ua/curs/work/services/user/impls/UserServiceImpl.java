package ua.curs.work.services.user.impls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.curs.work.entities.User;
import ua.curs.work.repositoryes.UserRepository;
import ua.curs.work.services.user.interfaces.iUserService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements iUserService {


    @Autowired
    UserRepository repository;

    @PostConstruct
    void init(){
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User get(String id) { return repository.findById(id).orElse(null);}

    @Override
    public List<User> getAll() { return repository.findAll(); }

    @Override
    public User edit(User user) {
        return repository.save(user);
    }

    @Override
    public User delete(String id) {
        User user = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return null;
    }
}
