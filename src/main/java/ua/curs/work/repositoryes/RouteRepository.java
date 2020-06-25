package ua.curs.work.repositoryes;


import org.springframework.data.mongodb.repository.MongoRepository;
import ua.curs.work.entities.City;
import ua.curs.work.entities.Route;

import java.util.List;


public interface RouteRepository extends MongoRepository<Route, String> {

    List<Route> findByFromCityAndToCityAndDateDepartureIsLikeAndActiveIsLike(City fromCity, City toCity, String dateDeparture, String active);

}
