package model.Hibernate.TablesManager;

import model.Hibernate.Tables.Characterize_Recipe;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class CharacterizeRecipeManager extends Manager<Characterize_Recipe> {

    public List<Integer> findTypeByIdRecipe(Integer id_recipe) {
        String sqlQuery = "SELECT x FROM Characterize_Recipe x WHERE x.id_recipe = " + id_recipe;
        List<Characterize_Recipe> foodRecipes = MakeQuery(Characterize_Recipe.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();
        for (Characterize_Recipe recipe : foodRecipes) {
            result.add(recipe.getId_recipe_type());
        }

        return result;
    }

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
