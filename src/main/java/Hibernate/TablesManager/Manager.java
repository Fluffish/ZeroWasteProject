package Hibernate.TablesManager;

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
        Connect(tableName);

        entityManager.getTransaction().begin();
        entityManager.persist(newItem);
        entityManager.getTransaction().commit();

        Disconnect();
    }

    void Disconnect() {
        entityManager.close();
        factory.close();
    }

}
