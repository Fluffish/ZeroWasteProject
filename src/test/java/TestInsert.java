import Hibernate.TablesManager.StorageTypeManager;

public class TestInsert {

    public static void main(String[] args) {

        StorageTypeManager storageTypeManager = new StorageTypeManager();
        System.out.println(storageTypeManager.FindStorageById(2).getStorage_name());

    }
}
