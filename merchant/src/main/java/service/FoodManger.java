package service;

import pojo.Food;
import pojo.Merchant;
import pojo.Pager;

import java.util.List;

/**
 * @author Dunn
 */
public interface FoodManger {
    Pager findAllFood(int curPage, int pageSize);
    Food addFood(String mid,Food food);
    void deleteFood(String id);
    Food updateFood(String mid,Food food);
    Pager findFoodByMerchant(int curPage, int pageSize,Merchant merchant);
    Pager findFoodByName(int curPage, int pageSize,String name);
}
