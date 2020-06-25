package ua.curs.work.services.comfortClass.interfaces;





import ua.curs.work.entities.ComfortClass;

import java.util.List;

public interface iComfortClassService {
    ComfortClass save(ComfortClass busClass);
    ComfortClass get(String id);
    List<ComfortClass> getAll();
    ComfortClass edit(ComfortClass busClass);
    ComfortClass delete(String id);
}
