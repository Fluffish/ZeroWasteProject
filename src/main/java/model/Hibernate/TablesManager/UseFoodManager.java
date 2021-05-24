package model.Hibernate.TablesManager;

import model.Hibernate.Tables.Food;
import model.Hibernate.Tables.Use_Food;

import java.util.ArrayList;
import java.util.List;

public class UseFoodManager extends Manager<Use_Food> {

    public List<Integer> FindUsedFood(Integer id_recipe) {
        String sqlQuery = "SELECT x FROM Use_Food x WHERE x.id_recipe = " + id_recipe;
        List<Use_Food> usedFood = MakeQuery(Use_Food.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (Use_Food used : usedFood) {
            result.add(used.getId_food());
        }
        return result;
    }

    public List<Food> GetUsedFood(Integer id_recipe) {
        FoodManager foodManager = new FoodManager();
        String sqlQuery = "SELECT x FROM Use_Food x WHERE x.id_recipe = " + id_recipe;
        List<Use_Food> usedFood = MakeQuery(Use_Food.class.getName(), sqlQuery);

        List<Food> result = new ArrayList<>();

        for (Use_Food used : usedFood) {
            Food food = foodManager.FindFoodById(used.getId_food());
            result.add(food);
        }
        return result;
    }
}
