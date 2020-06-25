package ua.curs.work.services.city.interfaces;



import ua.curs.work.entities.City;

import java.util.List;

public interface iCityService {
    City save(City city);
    City get(String id);
    List<City> getAll();
    City edit(City city);
    City delete(String id);
}
