package dao;

import entity.Person;

import java.util.List;

public interface PersonDao {
    public List<Person> getMaintenanceWorkers(String facilityName);

}
