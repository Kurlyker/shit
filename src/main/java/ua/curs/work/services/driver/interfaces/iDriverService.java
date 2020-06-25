package ua.curs.work.services.driver.interfaces;



import ua.curs.work.entities.Driver;

import java.util.List;

public interface iDriverService {
    Driver save(Driver driver);
    Driver get(String id);
    List<Driver> getAll();
    Driver edit(Driver driver);
    Driver delete(String id);
}
