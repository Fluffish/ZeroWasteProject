package model.Hibernate.Tables;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "food")
public class Food {
    private Integer id_food;
    private String food_name;

    public Food() {
    }

    public Food(String food_name) {
        this.food_name = food_name;
    }

    public Food(Integer id_food, String food_name) {
        this.id_food = id_food;
        this.food_name = food_name;
    }

    @Id
    @Column(name = "id_food")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_food() {
        return id_food;
    }

    public void setId_food(Integer id_food) {
        this.id_food = id_food;
    }

    @Column(name = "food_name")
    @NotNull
    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }
}
