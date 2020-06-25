package ua.curs.work.repositoryes;


import org.springframework.data.mongodb.repository.MongoRepository;
import ua.curs.work.entities.Ticket;

import java.util.List;


public interface TicketRepository extends MongoRepository<Ticket, String> {

    List<Ticket> findAllByUser(String user);

    List<Ticket> findAllByRoute_Id(String id);


}
