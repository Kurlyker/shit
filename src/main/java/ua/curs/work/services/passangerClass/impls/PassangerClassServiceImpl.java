package ua.curs.work.services.passangerClass.impls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.curs.work.entities.PassangerClass;
import ua.curs.work.repositoryes.PassangerClassRepository;
import ua.curs.work.services.passangerClass.interfaces.iPassangerClassService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PassangerClassServiceImpl implements iPassangerClassService {


    @Autowired
    PassangerClassRepository repository;

    @PostConstruct
    void init(){
    }

    @Override
    public PassangerClass save(PassangerClass passangerClass) {
        return repository.save(passangerClass);
    }

    @Override
    public PassangerClass get(String id) { return repository.findById(id).orElse(null);}

    @Override
    public List<PassangerClass> getAll() { return repository.findAll(); }

    @Override
    public PassangerClass edit(PassangerClass passangerClass) {
        return repository.save(passangerClass);
    }

    @Override
    public PassangerClass delete(String id) {
        PassangerClass passangerClass = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return null;
    }

}
