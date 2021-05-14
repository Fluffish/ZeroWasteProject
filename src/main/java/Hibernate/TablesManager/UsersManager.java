package Hibernate.TablesManager;

import Hibernate.Tables.Users;

public class UsersManager extends Manager<Users> {

    public Users FindUser(Integer id_user) {
        Connect(Users.class.getName());

        entityManager.getTransaction().begin();
        Users user = entityManager.find(Users.class,id_user);
        entityManager.getTransaction().commit();

        Disconnect();

        return user;
    }

    public void Merge(Users user) {
        Connect(user.getClass().getName());

        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();

        Disconnect();
    }

    public void Remove(Users user) {

        Connect(user.getClass().getName());

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
        entityManager.getTransaction().commit();

        Disconnect();
    }
}
