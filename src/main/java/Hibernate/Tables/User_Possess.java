package Hibernate.Tables;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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


    public User_Possess(Integer id_user, Integer id_storage) {
        this.id_user = id_user;
        this.id_storage = id_storage;
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
}
