package Hibernate.Tables;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "user_possess")
public class User_Possess {
    @Id
    @Column(name = "id_user")
    @NotNull
    private Integer id_user;

    @Id
    @Column(name = "id_storage")
    @NotNull
    private Integer id_storage;

    @Id
    @Column(name = "id_food")
    @NotNull
    private Integer id_food;

    @Id
    @Column(name = "quantity")
    private String quantity;

    @Column(name = "food_limit_date")
    @NotNull
    private Timestamp food_limit_date;

    @Column(name = "food_add_date")
    @NotNull
    private Timestamp food_add_date;

    @Column(name = "food_price")
    @NotNull
    private Float food_price;

    public User_Possess(Integer id_user, Integer id_storage, Integer id_food, Timestamp food_limit_date, Timestamp food_add_date, Float food_price) {
        this.id_user = id_user;
        this.id_storage = id_storage;
        this.id_food = id_food;
        this.food_limit_date = food_limit_date;
        this.food_add_date = food_add_date;
        this.food_price = food_price;
    }

    public User_Possess(Integer id_user, Integer id_storage, Integer id_food, String quantity, Timestamp food_limit_date, Timestamp food_add_date, Float food_price) {
        this.id_user = id_user;
        this.id_storage = id_storage;
        this.id_food = id_food;
        this.quantity = quantity;
        this.food_limit_date = food_limit_date;
        this.food_add_date = food_add_date;
        this.food_price = food_price;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_storage() {
        return id_storage;
    }

    public void setId_storage(Integer id_storage) {
        this.id_storage = id_storage;
    }

    public Integer getId_food() {
        return id_food;
    }

    public void setId_food(Integer id_food) {
        this.id_food = id_food;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Timestamp getFood_limit_date() {
        return food_limit_date;
    }

    public void setFood_limit_date(Timestamp food_limit_date) {
        this.food_limit_date = food_limit_date;
    }

    public Timestamp getFood_add_date() {
        return food_add_date;
    }

    public void setFood_add_date(Timestamp food_add_date) {
        this.food_add_date = food_add_date;
    }

    public Float getFood_price() {
        return food_price;
    }

    public void setFood_price(Float food_price) {
        this.food_price = food_price;
    }
}
