package Hibernate.TablesManager;

import Hibernate.Tables.Storage_Type;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StorageTypeManager implements Manager {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    @Override
    public void Connect() {
        factory = Persistence.createEntityManagerFactory("StorageTypeUnit");
        entityManager = factory.createEntityManager();
    }

    public void Insert() {

        entityManager.getTransaction().begin();

        Storage_Type newStorage = new Storage_Type();
        newStorage.setStorage_name("Placard");
        newStorage.setStorage_temp(20);

        entityManager.persist(newStorage);

        entityManager.getTransaction().commit();

    }

    @Override
    public void Disconnect() {
        entityManager.close();
        factory.close();
    }

}
