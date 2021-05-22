package model.Hibernate.Tables;

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "food_type")
public class Food_Type {
    private Integer id_food_type;
    private String food_type_name;

    public Food_Type() {
    }

    public Food_Type(String food_type_name) {
        this.food_type_name = food_type_name;
    }

    public Food_Type(Integer id_food_type, String food_type_name) {
        this.id_food_type = id_food_type;
        this.food_type_name = food_type_name;
    }

    @Id
    @Column(name = "id_food_type")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_food_type() {
        return id_food_type;
    }

    public void setId_food_type(Integer id_food_type) {
        this.id_food_type = id_food_type;
    }

    @Column(name = "food_type_name")
    @NotNull
    public String getFood_type_name() {
        return food_type_name;
    }

    public void setFood_type_name(String food_type_name) {
        this.food_type_name = food_type_name;
    }
}
