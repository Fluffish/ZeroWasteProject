package Hibernate.Tables;
import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    private Integer id_user;
    private String username;
    private String password;
    private String mail_user;
    private String tel_user;
    private Integer user_max_budget;
    private Integer user_current_budget;
    private boolean is_admin;

    public Users() {
    }

    public Users(String username, String password, String mail_user, String tel_user, Integer user_max_budget, Integer user_current_budget) {
        this.username = username;
        this.password = password;
        this.mail_user = mail_user;
        this.tel_user = tel_user;
        this.user_max_budget = user_max_budget;
        this.user_current_budget = user_current_budget;
    }

    public Users(Integer id_user, String username, String password, String mail_user, String tel_user, Integer user_max_budget, Integer user_current_budget, boolean is_admin) {
        this.id_user = id_user;
        this.username = username;
        this.password = password;
        this.mail_user = mail_user;
        this.tel_user = tel_user;
        this.user_max_budget = user_max_budget;
        this.user_current_budget = user_current_budget;
        this.is_admin = is_admin;
    }

    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    @Column(name = "username")
    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "mail_user")
    @NotNull
    public String getMail_user() {
        return mail_user;
    }

    public void setMail_user(String mail_user) {
        this.mail_user = mail_user;
    }

    @Column(name = "tel_user")
    @NotNull
    public String getTel_user() {
        return tel_user;
    }

    public void setTel_user(String tel_user) {
        this.tel_user = tel_user;
    }

    @Column(name = "user_max_budget")
    @NotNull
    public Integer getUser_max_budget() {
        return user_max_budget;
    }

    public void setUser_max_budget(Integer user_max_budget) {
        this.user_max_budget = user_max_budget;
    }

    @Column(name = "user_current_budget")
    @NotNull
    public Integer getUser_current_budget() {
        return user_current_budget;
    }

    public void setUser_current_budget(Integer user_current_budget) {
        this.user_current_budget = user_current_budget;
    }

    @Column(name = "is_admin")
    @NotNull
    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}
