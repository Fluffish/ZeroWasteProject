package Hibernate.Tables;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "recipe_type")
public class Recipe_Type {
    private Integer id_recipe_type;
    private String recipe_type_name;

    public Recipe_Type(Integer id_recipe_type, String recipe_type_name) {
        this.id_recipe_type = id_recipe_type;
        this.recipe_type_name = recipe_type_name;
    }

    @Id
    @Column(name = "id_recipe_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_recipe_type() {
        return id_recipe_type;
    }

    public void setId_recipe_type(Integer id_recipe_type) {
        this.id_recipe_type = id_recipe_type;
    }

    @Column(name = "recipe_type_name")
    @NotNull
    public String getRecipe_type_name() {
        return recipe_type_name;
    }

    public void setRecipe_type_name(String recipe_type_name) {
        this.recipe_type_name = recipe_type_name;
    }
}
