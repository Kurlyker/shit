package ua.curs.work.services.driver.impls;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.curs.work.entities.Driver;
import ua.curs.work.repositoryes.DriversRepository;
import ua.curs.work.services.driver.interfaces.iDriverService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class DriverServiceImpl implements iDriverService {


    @Autowired
    DriversRepository repository;

    @PostConstruct
    void init(){
    }

    @Override
    public Driver save(Driver driver) {
        return repository.save(driver);
    }

    @Override
    public Driver get(String id) { return repository.findById(id).orElse(null);}

    @Override
    public List<Driver> getAll() { return repository.findAll(); }

    @Override
    public Driver edit(Driver driver) {
        return repository.save(driver);
    }


    @Override
    public Driver delete(String id) {
        Driver driver = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return null;
    }
}
