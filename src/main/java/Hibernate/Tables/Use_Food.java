package Hibernate.Tables;

import javax.persistence.*;

@Entity
@Table(name = "use_food")
public class Use_Food {
    private Integer id_recipe;
    private Integer id_food;
    private String quantity;

    @Id
    @Column(name = "id_recipe")
    public Integer getId_recipe() {
        return id_recipe;
    }

    public void setId_recipe(Integer id_recipe) {
        this.id_recipe = id_recipe;
    }

    @Id
    @Column(name = "id_food")
    public Integer getId_food() {
        return id_food;
    }

    public void setId_food(Integer id_food) {
        this.id_food = id_food;
    }

    @Column(name = "quantity")
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
