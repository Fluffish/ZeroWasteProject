package Hibernate.TablesManager;

import Hibernate.Tables.Characterize_Recipe;
import java.util.ArrayList;
import java.util.List;

public class CharacterizeRecipeManager extends Manager<Characterize_Recipe> {

    public List<Integer> findIdRecipeByType(Integer id_recipe_type) {
        String sqlQuery = "SELECT x FROM Characterize_Recipe x WHERE x.id_recipe_type = " + id_recipe_type;
        List<Characterize_Recipe> foodRecipes = MakeQuery(Characterize_Recipe.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (Characterize_Recipe recipe : foodRecipes) {
            result.add(recipe.getId_recipe());
        }
        return result;
    }
}
