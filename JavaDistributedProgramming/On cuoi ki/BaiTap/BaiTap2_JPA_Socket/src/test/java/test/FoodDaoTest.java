package test;

import dao.FoodDao;
import daoImpl.FoodImpl;
import entity.Food;
import entity.Type;
import jakarta.persistence.Table;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FoodDaoTest {
    private FoodDao foodDao;


    public void setUp()
    {
        foodDao = new FoodImpl();
    }

//    @Test
//    public void testaddFood_true(){
//        setUp();
//        Food food = new Food("F112", Type.MAIN_COURSE, 30,20);
//        assertTrue(foodDao.addFood(food));
//    }

//    @Test
//    public void testaddFood_false(){
//        setUp();
//        Food food = new Food("A123", Type.MAIN_COURSE, 30,20);
//         assertFalse(foodDao.addFood(food));
//    }


    @Test
    public void testlistFoodAndCost(){
        setUp();
        Map<Food, Double> map = foodDao.listFoodAndCost();
        map.forEach((k,v) -> System.out.println(k + " " + v));
        assertFalse(map.isEmpty());

    }





    @AfterEach
    public void tearDown()
    {
        foodDao = null;
    }
}
