package ua.curs.work.services.bus.interfaces;



import ua.curs.work.entities.Bus;

import java.util.List;

public interface iBusService {
    Bus save(Bus bus);
    Bus get(String id);
    List<Bus> getAll();
    Bus edit(Bus bus);
    Bus delete(String id);
}
