package model.Hibernate.TablesManager;

import model.Hibernate.Tables.Food_Type;
import java.util.ArrayList;
import java.util.List;

public class FoodTypeManager extends Manager<Food_Type> {

    public List<Integer> findIdType(String food_type_name) {
        String sqlQuery = "SELECT x FROM Food_Type x WHERE x.food_type_name = '" + food_type_name + "'";
        List<Food_Type> typeFound = MakeQuery(Food_Type.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (Food_Type type : typeFound) {
            result.add(type.getId_food_type());
        }
        return result;
    }

    public List<Food_Type> getAllFoodType() {
        String sqlQuery = "SELECT x FROM Food_Type x";
        List<Food_Type> typeFound = MakeQuery(Food_Type.class.getName(), sqlQuery);
        return typeFound;
    }
}
