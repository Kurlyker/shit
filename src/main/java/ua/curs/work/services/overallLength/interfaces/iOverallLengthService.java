package ua.curs.work.services.overallLength.interfaces;



import ua.curs.work.entities.OverallLength;

import java.util.List;

public interface iOverallLengthService {
    OverallLength save(OverallLength overallLength);
    OverallLength get(String id);
    List<OverallLength> getAll();
    OverallLength edit(OverallLength overallLength);
    OverallLength delete(String id);
}
