package ua.curs.work.services.bus.impls;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.curs.work.entities.Bus;
import ua.curs.work.repositoryes.BusesRepository;
import ua.curs.work.services.bus.interfaces.iBusService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BusServiceImpl implements iBusService {


    @Autowired
    BusesRepository repository;

    @PostConstruct
    void init(){
    }

    @Override
    public Bus save(Bus bus) {
        return repository.save(bus);
    }

    @Override
    public Bus get(String id) { return repository.findById(id).orElse(null);}

    @Override
    public List<Bus> getAll() { return repository.findAll(); }

    @Override
    public Bus edit(Bus bus) {
        return repository.save(bus);
    }

    @Override
    public Bus delete(String id) {
        Bus bus = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return null;
    }
}
