package dao;

import entity.Food;

import java.util.Map;

public interface FoodDao {
    public boolean addFood(Food food);
    public Map<Food, Double> listFoodAndCost();
}
