package ua.curs.work.services.ticket.interfaces;




import ua.curs.work.entities.Ticket;

import java.util.List;

public interface iTicketService {
    List<Ticket> findByUser(String user);
    Ticket save(Ticket ticket);
    Ticket get(String id);
    List<Ticket> getAll();
    Ticket edit(Ticket ticket);
    Ticket delete(String id);

    List<Ticket> findByRoute(String id);
}
