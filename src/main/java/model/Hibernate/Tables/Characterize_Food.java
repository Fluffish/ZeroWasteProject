package Hibernate.Tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "characterize_food")
public class Characterize_Food {
    private Integer id_food;
    private Integer id_food_type;

    public Characterize_Food(Integer id_food, Integer id_food_type) {
        this.id_food = id_food;
        this.id_food_type = id_food_type;
    }

    @Id
    @Column(name = "id_food")
    public Integer getId_food() {
        return id_food;
    }

    public void setId_food(Integer id_food) {
        this.id_food = id_food;
    }

    @Id
    @Column(name = "id_food_type")
    public Integer getId_food_type() {
        return id_food_type;
    }

    public void setId_food_type(Integer id_food_type) {
        this.id_food_type = id_food_type;
    }
}
