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
        em= Persistence.createEntityManagerFactory("JPA_Baithi_MSSQL").createEntityManager();
    }


    /**
     * --Thêm một món ăn mới. Trong đó, mã số của món phải bắt đầu là F và theo sau ít  nhất 3 ký số
     * @param food
     * @return
     */
    @Override
    public boolean addFood(Food food) {
        EntityTransaction tx = em.getTransaction();
        try {
            //mã số của món phải bắt đầu là F và theo sau ít  nhất 3 ký số
            if (!food.getId().matches("^F\\d{3,}$")) {
                return false;
            }
            tx.begin();
            em.persist(food);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Map<Food, Double> listFoodAndCost() {
        Map<Food, Double> map = new LinkedHashMap<>();
        List<?> list = em.createNamedQuery("Food.listFoodAndCost").getResultList();
        list.stream()
                .map(o -> (Object[]) o)
                .forEach(a -> {

                    Food food = em.find(Food.class, a[0]);
                    Double cost = (Double) a[1];
                    if(cost != null){
                        map.put(food, cost);
                    }
                });

        return map;
    }
}
