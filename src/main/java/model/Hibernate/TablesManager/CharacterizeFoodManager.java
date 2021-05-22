package model.Hibernate.TablesManager;

import model.Hibernate.Tables.Characterize_Food;

import java.util.ArrayList;
import java.util.List;

public class CharacterizeFoodManager extends Manager<Characterize_Food> {

    public List<Integer> findIdFoodByType(Integer id_recipe_type) {
        String sqlQuery = "SELECT x FROM Characterize_Food x WHERE x.id_food_type = " + id_recipe_type;
        List<Characterize_Food> foodRecipes = MakeQuery(Characterize_Food.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (Characterize_Food food : foodRecipes) {
            result.add(food.getId_food());
        }
        return result;
    }
}
