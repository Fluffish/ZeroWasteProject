package model.Hibernate.TablesManager;

import model.Hibernate.Tables.Recipe;

public class RecipeManager extends Manager<Recipe> {

    public Recipe FindRecipeById(Integer id_recipe) {
        Connect(Recipe.class.getName());

        entityManager.getTransaction().begin();
        Recipe recipe = entityManager.find(Recipe.class,id_recipe);
        entityManager.getTransaction().commit();

        Disconnect();
        return recipe;
    }
}
