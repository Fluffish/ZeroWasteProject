package Hibernate.TablesManager;

import Hibernate.Tables.Storage_Type;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public abstract class Manager<Class> {
    EntityManagerFactory factory;
    EntityManager entityManager;

    void Connect(String tableName) {
        String[] path = tableName.split("\\.");
        String unitName = path[path.length - 1].concat("Unit");

        factory = Persistence.createEntityManagerFactory(unitName);
        entityManager = factory.createEntityManager();
    }

    public List<Class> MakeQuery(String tableName, String sqlQuery) {
        Connect(tableName);

        Query query = entityManager.createQuery(sqlQuery);
        List<Class> resultQuery = query.getResultList();

        Disconnect();

        return resultQuery;
    }

    public void Insert(String tableName, Class newItem) {
        try {
            if (newItem.getClass().getName().equals(tableName)) {
                Connect(tableName);

                entityManager.getTransaction().begin();
                entityManager.persist(newItem);
                entityManager.getTransaction().commit();

                Disconnect();
            }
        }
        catch (Exception e) {
            System.out.println("Mauvaise table utilisée.");
        }

    }

    public void Merge(String tableName, Class itemToUpdate) {
        try {
            if (itemToUpdate.getClass().getName().equals(tableName)) {
                Connect(tableName);

                entityManager.getTransaction().begin();
                entityManager.merge(itemToUpdate);
                entityManager.getTransaction().commit();

                Disconnect();
            }
        }
        catch (Exception e){
            System.out.println("Mauvaise table utilisée.");
        }
    }

    public void Remove(String tableName, Class itemToRemove) {
        try {
            if (itemToRemove.getClass().getName().equals(tableName)) {
                Connect(tableName);

                Connect(Storage_Type.class.getName());

                entityManager.getTransaction().begin();
                entityManager.remove(entityManager.contains(itemToRemove) ? itemToRemove : entityManager.merge(itemToRemove));
                entityManager.getTransaction().commit();

                Disconnect();
            }
        }
        catch (Exception e) {
            System.out.println("Mauvaise table utilisée.");
        }
    }

    void Disconnect() {
        entityManager.close();
        factory.close();
    }

}
