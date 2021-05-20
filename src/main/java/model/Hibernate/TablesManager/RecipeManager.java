package model.Hibernate.TablesManager;

import model.Hibernate.Tables.Food;
import model.Hibernate.Tables.Recipe;

import java.util.List;

public class RecipeManager extends Manager<Recipe> {

    public List<Recipe> GetAllRecipe() {
        String sqlQuery = "SELECT x FROM Recipe x";
        List<Recipe> recipes = MakeQuery(Recipe.class.getName(), sqlQuery);

        return recipes;
    }

    public Recipe FindRecipeById(Integer id_recipe) {
        Connect(Recipe.class.getName());

        entityManager.getTransaction().begin();
        Recipe recipe = entityManager.find(Recipe.class,id_recipe);
        entityManager.getTransaction().commit();

        Disconnect();
        return recipe;
    }
}
