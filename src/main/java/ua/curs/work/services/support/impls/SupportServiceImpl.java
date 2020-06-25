package ua.curs.work.services.support.impls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.curs.work.entities.Support;
import ua.curs.work.repositoryes.SupportRepository;
import ua.curs.work.services.support.interfaces.iSupportService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class SupportServiceImpl implements iSupportService {


    @Autowired
    SupportRepository repository;

    @PostConstruct
    void init(){
    }

    @Override
    public Support save(Support support) {
        return repository.save(support);
    }

    @Override
    public Support get(String id) { return repository.findById(id).orElse(null);}

    @Override
    public List<Support> getAll() { return repository.findAll(); }

    @Override
    public Support edit(Support support) {
        return repository.save(support);
    }

    @Override
    public Support delete(String id) {
        Support support = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Support> getActive(Boolean active) { return repository.findByActive(active); }
}
