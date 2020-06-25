package ua.curs.work.services.passangerClass.interfaces;






import ua.curs.work.entities.PassangerClass;

import java.util.List;

public interface iPassangerClassService {
    PassangerClass save(PassangerClass passangerClass);
    PassangerClass get(String id);
    List<PassangerClass> getAll();
    PassangerClass edit(PassangerClass passangerClass);
    PassangerClass delete(String id);
}
