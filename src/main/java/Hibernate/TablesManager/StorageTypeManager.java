package Hibernate.TablesManager;

import Hibernate.Tables.Storage_Type;

public class StorageTypeManager extends Manager<Storage_Type> {

    public Storage_Type FindStorageById(Integer id_storage) {
        Connect(Storage_Type.class.getName());

        entityManager.getTransaction().begin();
        Storage_Type storage_type = entityManager.find(Storage_Type.class, id_storage);
        entityManager.getTransaction().commit();

        Disconnect();

        return storage_type;
    }
}
