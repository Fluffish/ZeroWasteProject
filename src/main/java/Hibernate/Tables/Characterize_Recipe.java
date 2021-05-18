package Hibernate.Tables;

import javax.persistence.*;

@Entity
@Table(name = "characterize_recipe")
public class Characterize_Recipe {
    private Integer id_recipe;
    private Integer id_recipe_type;

    public Characterize_Recipe(Integer id_recipe, Integer id_recipe_type) {
        this.id_recipe = id_recipe;
        this.id_recipe_type = id_recipe_type;
    }

    @Id
    @Column(name = "id_recipe")
    public Integer getId_recipe() {
        return id_recipe;
    }

    public void setId_recipe(Integer id_recipe) {
        this.id_recipe = id_recipe;
    }

    @Id
    @Column(name = "id_recipe_type")
    public Integer getId_recipe_type() {
        return id_recipe_type;
    }

    public void setId_recipe_type(Integer id_recipe_type) {
        this.id_recipe_type = id_recipe_type;
    }
}
