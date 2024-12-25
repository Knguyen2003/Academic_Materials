package daoImpl;

import dao.FacilityDao;
import entity.Facility;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.*;

public class FacilityImpl implements FacilityDao {
    private EntityManager em;

    public FacilityImpl() {
        em = Persistence.createEntityManagerFactory("JPA_Baithi_MSSQL").createEntityManager();
    }

    @Override
    public boolean updateFacility(Facility facilityNewInfor) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Facility facility = em.find(Facility.class, facilityNewInfor.getId());
            if (facility == null) {
                return false;
            }else{
                if(facilityNewInfor.getPrice() < facility.getPrice()){
                    int number =  em.createNamedQuery("Facility.updateFacility")
                            .setParameter("description", facilityNewInfor.getDescription())
                            .setParameter("price", facilityNewInfor.getPrice())
                            .setParameter("status", facilityNewInfor.getStatus())
                            .setParameter("location", facilityNewInfor.getLocation())
                            .setParameter("id", facilityNewInfor.getId())
                            .executeUpdate();
//                    em.merge(facilityNewInfor);
                    tx.commit();
                    return number > 0;
                }
            }
        } catch (Exception e) {
            tx.rollback();

        }
        return false;
    }






    @Override
    public Map<Facility, Long> countMaintenance() {
        //sắp xếp theo tên facility
       Map<Facility, Long> map = new TreeMap<>(
               //sắp xếp theo tên facility theo thứ tự tăng dần
               Comparator.comparing(Facility::getName)
//                       .thenComparing(Facility::getId)
       );
        try {
            List<?> list = em.createNamedQuery("Facility.countMaintenance1").getResultList();
            list.stream()
                    .map(objects -> (Object[]) objects)
                    .forEach(objects -> {
                        Facility facility = em.find(Facility.class, objects[0]);
                        map.put(facility, Long.valueOf(objects[1].toString()));
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
