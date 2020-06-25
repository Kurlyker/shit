package ua.curs.work.services.route.impls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.curs.work.entities.City;
import ua.curs.work.entities.Route;
import ua.curs.work.repositoryes.RouteRepository;
import ua.curs.work.services.route.interfaces.iRouteService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RouteServiceImpl implements iRouteService {


    @Autowired
    RouteRepository repository;


    @PostConstruct
    void init(){
    }

    @Override
    public Route save(Route route) {
        return repository.save(route);
    }

    @Override
    public Route get(String id) { return repository.findById(id).orElse(null);}

/*
    @Override
    public Route getRoutes(String fromCity) {
        return this.getAll().stream()
                .filter(item-> item.getFromCity().equals(fromCity))
                .findFirst().orElse(null);
                //.findFirst().orElse(null);
    }
 */
/*
    @Override
    public List<Route> getRoutes(String fromCity, String toCity, String dateDeparture) {
        return repository.findByFromCityAndToCityAndDateDeparture(fromCity, toCity, dateDeparture);
    }
*/


    /*
        @Override
        public Route getByFromCity(String fromCity) {

            return this.getAll().stream()
                    .filter(item-> item.getFromCity().equals(fromCity))
                    .findFirst().orElse(null)
                    ;
        }

     */

    @Override
    public List<Route> getRoute(City fromCity, City toCity, String dateDeparture, String active){
        //return repository.findByFromCityAndToCityAndDateDepartureIsLike(fromCity,toCity,dateDeparture);
        return repository.findByFromCityAndToCityAndDateDepartureIsLikeAndActiveIsLike(fromCity,toCity,dateDeparture,active);
    }


    @Override
    public List<Route> getAll() { return repository.findAll(); }

    @Override
    public Route edit(Route route) {
        return repository.save(route);
    }

    @Override
    public Route delete(String id) {
        Route route = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return null;
    }


    public Route findById(String id) {
        return repository.findById(id).orElse(null);
    }
}
