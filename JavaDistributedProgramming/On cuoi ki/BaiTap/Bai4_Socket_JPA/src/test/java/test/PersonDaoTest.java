package test;

import dao.PersonDao;
import daoImpl.PersonImpl;
import entity.Person;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.util.List;

public class PersonDaoTest {

    private PersonDao personDao;


    public void setUp(){
        personDao = new PersonImpl();
    }

    @Test
    public void testGetMaintenanceWorkers(){
        setUp();
        List<Person> persons = personDao.getMaintenanceWorkers("C");
        if(persons != null){
            for (Person person : persons) {
                System.out.println(person);
            }
        }
    }

    @AfterEach
    public void tearDown(){
        personDao = null;
    }
}
