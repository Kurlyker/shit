package ua.curs.work.services.support.interfaces;





import ua.curs.work.entities.Support;

import java.util.List;

public interface iSupportService {
    Support save(Support support);
    Support get(String id);
    List<Support> getAll();
    Support edit(Support support);
    Support delete(String id);

    List<Support> getActive(Boolean active);
}
