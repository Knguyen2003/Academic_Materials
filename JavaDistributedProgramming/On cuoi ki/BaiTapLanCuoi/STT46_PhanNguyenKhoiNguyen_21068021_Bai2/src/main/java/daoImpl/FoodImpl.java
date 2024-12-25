package daoImpl;

import dao.FoodDao;
import entity.Food;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FoodImpl implements FoodDao {
    private EntityManager em;

    public FoodImpl() {
        em = Persistence.createEntityManagerFactory("JPA_Baithi_MSSQL").createEntityManager();
    }

    //Trong đó, mã số của món phải bắt đầu là F và theo sau ít
    //nhất 3 ký số.
    @Override
    public boolean addFood(Food food) {
        EntityTransaction tx = em.getTransaction();
        try {
            if(!food.getId().matches("F\\d{3,}")) {
                return false;
            }
            tx.begin();
            em.persist(food);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        }
    }

    @Override
    public Map<Food, Double> listFoodAndCost() {
        Map<Food, Double> result = new LinkedHashMap<>();
        List<?> ds = em.createNamedQuery("Food.listFoodAndCost").getResultList();
        ds.stream()
                .map(o -> (Object[]) o)
                .forEach(objects -> {
                    Food f = em.find(Food.class, objects[0]);

                    result.put(f, (Double) objects[1]);
                });
        return result;
    }
}
