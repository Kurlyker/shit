package ua.curs.work.services.city.impls;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.curs.work.entities.City;
import ua.curs.work.repositoryes.CitiesRepository;
import ua.curs.work.services.city.interfaces.iCityService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CityServiceImpl implements iCityService {


    @Autowired
    CitiesRepository repository;

    @PostConstruct
    void init(){
    }

    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    public City get(String id) { return repository.findById(id).orElse(null);}

    @Override
    public List<City> getAll() { return repository.findAll(); }

    @Override
    public City edit(City city) {
        return repository.save(city);
    }

    @Override
    public City delete(String id) {
        City city = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return null;
    }

}
