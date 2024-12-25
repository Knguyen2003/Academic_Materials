package test;

import dao.FacilityDao;
import daoImpl.FacilityImpl;
import entity.Facility;
import entity.Status;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.lang.reflect.Type;
import java.util.Map;

import static org.junit.Assert.*;

public class FacilityDaoTest {
    private FacilityDao facilityDao;

    public void setUp(){
        facilityDao = new FacilityImpl();
    }

//   @Test
//   public void testUpdateFacility(){
//        setUp();
//       Facility facility = new Facility("F005", "Mô tả", 4000, Status.AVAILABLE, "Floor 7");
//       boolean result = facilityDao.updateFacility(facility);
////       assertFalse(result);
//       assertTrue(result);
//   }

   @Test
    public void testCountMaintenance() {
       setUp();
       Map<Facility, Long> map = facilityDao.countMaintenance();
       //Kiểm tra xem tên của facility có giảm dần
       map.forEach((k, v) -> {
           if(k.getName().equals("F001")){
               assertTrue(v == 1);
           }
           System.out.println(k + " " + v);
       });
       assertTrue(map.size() == 5);
       assertNotNull(map);
   }
    @AfterEach
    public void tearDown(){
        facilityDao = null;
    }

}
