package ua.curs.work.services.overallLength.impls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.curs.work.entities.OverallLength;
import ua.curs.work.repositoryes.OverallLengthRepository;
import ua.curs.work.services.overallLength.interfaces.iOverallLengthService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class OverallLengthServiceImpl implements iOverallLengthService {


    @Autowired
    OverallLengthRepository repository;

    @PostConstruct
    void init(){
    }

    @Override
    public OverallLength save(OverallLength overallLength) {
        return repository.save(overallLength);
    }

    @Override
    public OverallLength get(String id) { return repository.findById(id).orElse(null);}

    @Override
    public List<OverallLength> getAll() { return repository.findAll(); }

    @Override
    public OverallLength edit(OverallLength overallLength) {
        return repository.save(overallLength);
    }

    @Override
    public OverallLength delete(String id) {
        OverallLength overallLength = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return null;
    }

}
