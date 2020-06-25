package ua.curs.work.services.route.interfaces;


import ua.curs.work.entities.City;
import ua.curs.work.entities.Route;

import java.util.List;

public interface iRouteService {
    Route save(Route route);
    Route get(String id);

  //  List<Route> getRoutes(String fromCity, String toCity, String dateDeparture);

 //   Route getByFromCity(String fromCity);

    List<Route> getRoute(City fromCity, City toCity, String dateDeparture, String active);

    List<Route> getAll();
    Route edit(Route route);
    Route delete(String id);
}
