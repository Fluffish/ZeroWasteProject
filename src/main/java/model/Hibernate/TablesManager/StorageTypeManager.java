package model.Hibernate.TablesManager;

import model.Hibernate.Tables.Storage_Type;

import java.util.ArrayList;
import java.util.List;

public class StorageTypeManager extends Manager<Storage_Type> {

    public Storage_Type FindStorageById(Integer id_storage) {
        Connect(Storage_Type.class.getName());

        entityManager.getTransaction().begin();
        Storage_Type storage_type = entityManager.find(Storage_Type.class, id_storage);
        entityManager.getTransaction().commit();

        Disconnect();

        return storage_type;
    }

    public List<Integer> FindStorageByNameAndTemperature(String name, float temperature) {
        String sqlQuery = "SELECT x FROM Storage_Type x WHERE x.storage_name = '" + name + "' AND x.storage_temp = '" + temperature + "'";
        List<Storage_Type> typeFound = MakeQuery(Storage_Type.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (Storage_Type type : typeFound) {
            result.add(type.getId_storage());
        }

        return result;
    }
}
