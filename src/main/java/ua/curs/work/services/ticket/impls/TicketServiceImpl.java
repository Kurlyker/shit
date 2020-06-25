package ua.curs.work.services.ticket.impls;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.curs.work.entities.Ticket;
import ua.curs.work.repositoryes.TicketRepository;
import ua.curs.work.services.ticket.interfaces.iTicketService;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TicketServiceImpl implements iTicketService {


    @Autowired
    TicketRepository repository;

    @PostConstruct
    void init(){
    }

    @Override
    public Ticket save(Ticket ticket) { return repository.save(ticket); }

    @Override
    public Ticket get(String id) { return repository.findById(id).orElse(null);}

    @Override
    public List<Ticket> getAll() { return repository.findAll(); }

    @Override
    public Ticket edit(Ticket ticket) {
        return repository.save(ticket);
    }

    @Override
    public Ticket delete(String id) {
        Ticket ticket = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Ticket> findByUser(String user){
        return repository.findAllByUser(user);
    }

    @Override
    public List<Ticket> findByRoute(String id){ return repository.findAllByRoute_Id(id); }

}
