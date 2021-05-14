package Hibernate.TablesManager;

import Hibernate.Tables.Use_Food;
import Hibernate.Tables.User_Possess;
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
}
