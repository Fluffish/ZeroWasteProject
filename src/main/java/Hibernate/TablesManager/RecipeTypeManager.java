package Hibernate.TablesManager;

import Hibernate.Tables.Recipe_Type;
import java.util.ArrayList;
import java.util.List;

public class RecipeTypeManager extends Manager<Recipe_Type> {

    public List<Integer> findIdType(String recipe_type_name) {
        String sqlQuery = "SELECT x FROM Recipe_Type x WHERE x.recipe_type_name = '" + recipe_type_name + "'";
        List<Recipe_Type> recipes = MakeQuery(Recipe_Type.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (Recipe_Type recipe : recipes) {
            result.add(recipe.getId_recipe_type());
        }
        return result;
    }

}