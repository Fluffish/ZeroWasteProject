package model.Hibernate.TablesManager;

import model.Hibernate.Tables.Food;
import java.util.ArrayList;
import java.util.List;

public class FoodManager extends Manager<Food> {

    public Boolean FoodAlreadyExist(String foodName) {
        String sqlQuery = "SELECT x FROM Food x WHERE x.food_name = '" + foodName + "'";
        List<Food> result = MakeQuery(Food.class.getName(), sqlQuery);
        return result.size() != 0;
    }

    public Food FindFoodByName(String name) {
        String sqlQuery = "SELECT x FROM Food x WHERE x.food_name = '" + name + "'";
        List<Food> foodFound = MakeQuery(Food.class.getName(), sqlQuery);

        if (foodFound.size() != 0) {
            return foodFound.get(0);
        }
        return null;
    }


    public List<Food> FindAllFood() {
        String sqlQuery = "SELECT x FROM Food x WHERE x.id_food != 1";
        List<Food> result = MakeQuery(Food.class.getName(), sqlQuery);
        return result;
    }

    public List<Integer> FindFoodByType(Integer id_food_type) {
        String sqlQuery = "SELECT x FROM Food x WHERE x.id_food_type = " + id_food_type;
        List<Food> foodFound = MakeQuery(Food.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (Food food : foodFound) {
            result.add(food.getId_food());
        }
        return result;
    }

    public Food FindFoodById(Integer id_food) {
        Connect(Food.class.getName());

        entityManager.getTransaction().begin();
        Food food = entityManager.find(Food.class, id_food);
        entityManager.getTransaction().commit();

        Disconnect();
        return food;
    }

}
