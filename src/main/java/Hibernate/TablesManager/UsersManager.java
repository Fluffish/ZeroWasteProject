package Hibernate.TablesManager;

import Hibernate.Tables.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsersManager implements Manager {

    public void Insert() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsersUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Users newUser = new Users();
        newUser.setUsername("Florent");
        newUser.setPassword("AdminZeroWaste");
        newUser.setMail_user("Florent@zeroWaste.com");
        newUser.setTel_user("06.06.06.06.06");
        newUser.setUser_max_budget(150);
        newUser.setUser_current_budget(0);

        entityManager.persist(newUser);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
}
