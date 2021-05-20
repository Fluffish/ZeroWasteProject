package model.Hibernate.Tables;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "recipe")
public class Recipe {

    private Integer id_recipe;
    private String recipe_name;

    public Recipe() {
    }

    public Recipe(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public Recipe(Integer id_recipe, String recipe_name) {
        this.id_recipe = id_recipe;
        this.recipe_name = recipe_name;
    }

    @Id
    @Column(name = "id_recipe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_recipe() {
        return id_recipe;
    }

    public void setId_recipe(Integer id_recipe) {
        this.id_recipe = id_recipe;
    }

    @Column(name = "recipe_name")
    @NotNull
    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }
}
