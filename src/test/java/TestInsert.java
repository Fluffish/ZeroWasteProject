import Hibernate.TablesManager.StorageTypeManager;

public class TestInsert {

    public static void main(String[] args) {

        StorageTypeManager storageTypeManager = new StorageTypeManager();
        System.out.println(storageTypeManager.FindStorage(2).getStorage_name());

        //UserPossessManager userPossessManager = new UserPossessManager();
        //userPossessManager.Insert(1, 3);
    }
}
