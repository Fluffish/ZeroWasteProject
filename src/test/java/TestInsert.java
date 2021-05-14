import Hibernate.Tables.Storage_Type;
import Hibernate.TablesManager.StorageTypeManager;

public class TestInsert {

    public static void main(String[] args) {

        StorageTypeManager storageTypeManager = new StorageTypeManager();
        //System.out.println(storageTypeManager.FindStorage(2).getStorage_name());
        storageTypeManager.Remove(Storage_Type.class.getName(), new Storage_Type(2,"Frigo", 2));

        //UserPossessManager userPossessManager = new UserPossessManager();
        //userPossessManager.Insert(1, 3);
    }
}
