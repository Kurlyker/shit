package ua.curs.work.services.comfortClass.impls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.curs.work.entities.ComfortClass;
import ua.curs.work.repositoryes.ComfortClassRepository;
import ua.curs.work.services.comfortClass.interfaces.iComfortClassService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ComfortClassServiceImpl implements iComfortClassService {


    @Autowired
    ComfortClassRepository repository;

    @PostConstruct
    void init(){
    }

    @Override
    public ComfortClass save(ComfortClass busClass) {
        return repository.save(busClass);
    }

    @Override
    public ComfortClass get(String id) { return repository.findById(id).orElse(null);}

    @Override
    public List<ComfortClass> getAll() { return repository.findAll(); }

    @Override
    public ComfortClass edit(ComfortClass busClass) {
        return repository.save(busClass);
    }

    @Override
    public ComfortClass delete(String id) {
        ComfortClass busClass = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return null;
    }

}
