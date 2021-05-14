package Hibernate.TablesManager;

import Hibernate.Tables.Storage_Type;

public class StorageTypeManager extends Manager<Storage_Type> {

    public Storage_Type FindStorage(Integer id_storage) {
        Connect(Storage_Type.class.getName());

        entityManager.getTransaction().begin();
        Storage_Type storage_type = entityManager.find(Storage_Type.class, id_storage);
        entityManager.getTransaction().commit();

        Disconnect();

        return storage_type;
    }

    public void Merge(Storage_Type storage_type) {
        Connect(Storage_Type.class.getName());

        entityManager.getTransaction().begin();
        entityManager.merge(storage_type);
        entityManager.getTransaction().commit();

        Disconnect();
    }

    public void Remove(Storage_Type storage_type) {

        Connect(Storage_Type.class.getName());

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.contains(storage_type) ? storage_type : entityManager.merge(storage_type));
        entityManager.getTransaction().commit();

        Disconnect();
    }
}
