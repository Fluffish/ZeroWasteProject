package Hibernate.TablesManager;

import Hibernate.Tables.Contains_Food;
import java.util.ArrayList;
import java.util.List;

public class ContainsFoodManager extends Manager<Contains_Food> {

    //TODO : CORRECT SQLQUERY WITH DATE COMPARISON.
    public List<Integer> FindVeryLimitedFood() {
        String sqlQuery = "SELECT x FROM Contains_Food x WHERE x.food_limit_date < CURRENT_TIMESTAMP + 7";
        List<Contains_Food> foodFound = MakeQuery(Contains_Food.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (Contains_Food food : foodFound) {
            result.add(food.getId_food());
        }
        return result;
    }

    public List<Integer> FindLimitedFood() {
        String sqlQuery = "SELECT x FROM Contains_Food x WHERE x.food_limit_date < CURRENT_TIMESTAMP + 14 and x.food_limit_date > CURRENT_TIMESTAMP + 7";
        List<Contains_Food> foodFound = MakeQuery(Contains_Food.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (Contains_Food food : foodFound) {
            result.add(food.getId_food());
        }
        return result;
    }
}
