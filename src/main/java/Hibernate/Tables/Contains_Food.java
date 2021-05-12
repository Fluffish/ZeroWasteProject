package Hibernate.Tables;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "contains_food")
public class Contains_Food {
    private Integer id_storage;
    private Integer id_food;
    private java.sql.Date food_limit_date;
    private java.sql.Date food_add_date;
    private float food_price;

    @Id
    @Column(name = "id_storage")
    public Integer getId_storage() {
        return id_storage;
    }

    public void setId_storage(Integer id_storage) {
        this.id_storage = id_storage;
    }

    @Id
    @Column(name = "id_food")
    public Integer getId_food() {
        return id_food;
    }

    public void setId_food(Integer id_food) {
        this.id_food = id_food;
    }

    @Column(name = "food_limit_date")
    @NotNull
    public Date getFood_limit_date() {
        return food_limit_date;
    }

    public void setFood_limit_date(Date food_limit_date) {
        this.food_limit_date = food_limit_date;
    }

    @Column(name = "food_add_date")
    @NotNull
    public Date getFood_add_date() {
        return food_add_date;
    }

    public void setFood_add_date(Date food_add_date) {
        this.food_add_date = food_add_date;
    }

    @Column(name = "food_price")
    @NotNull
    public float getFood_price() {
        return food_price;
    }

    public void setFood_price(float food_price) {
        this.food_price = food_price;
    }
}
