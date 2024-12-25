package daoImpl;

import dao.PersonDao;
import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class PersonImpl implements PersonDao {
    private EntityManager em;

    public PersonImpl() {
        em = Persistence.createEntityManagerFactory("JPA_Baithi_MSSQL").createEntityManager();
    }

    @Override
    public List<Person> getMaintenanceWorkers(String facilityName) {
        try {
            return em.createNamedQuery("Person.getMaintenanceWorkers1")
                    .setParameter("name","%" + facilityName+ "%")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
