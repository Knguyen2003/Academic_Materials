package test;

import dao.FoodDao;
import daoImpl.FoodImpl;
import entity.Food;
import entity.Type;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class FoodDaoTest {
    private FoodDao foodDao;


    public void setUp() {
        foodDao = new FoodImpl();
    }

//    @Test
//    public void testAddFood(){
//        setUp();
//        //String id, int preparationTime, int servingTime, Type type
//        Food food = new Food("F112", 15, 10, Type.MAIN_COURSE);
//        boolean result = foodDao.addFood(food);
//        assertTrue(result);
//    }

    @Test
    public void testListFoodAndCost(){
        setUp();
        Map<Food, Double> result = foodDao.listFoodAndCost();
        result.forEach((k, v) -> System.out.println(k + " " + v));
    }

    @AfterEach
    public void tearDown() {
        foodDao = null;
    }
}
