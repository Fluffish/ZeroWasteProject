package Hibernate.TablesManager;

import Hibernate.Tables.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsersManager implements Manager {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    @Override
    public void Connect() {
        factory = Persistence.createEntityManagerFactory("UsersUnit");
        entityManager = factory.createEntityManager();
    }

    public void Insert() {
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
    }

    @Override
    public void Disconnect() {
        entityManager.close();
        factory.close();
    }
}
