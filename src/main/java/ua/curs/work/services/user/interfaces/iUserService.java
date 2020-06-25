package ua.curs.work.services.user.interfaces;



import ua.curs.work.entities.User;

import java.util.List;

public interface iUserService {
    User save(User user);
    User get(String id);
    List<User> getAll();
    User edit(User driver);
    User delete(String id);
}
