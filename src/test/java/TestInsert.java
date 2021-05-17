import Hibernate.Tables.Users;
import Hibernate.TablesManager.StorageTypeManager;
import Hibernate.TablesManager.UserPossessManager;
import Hibernate.TablesManager.UsersManager;

public class TestInsert {

    public static void main(String[] args) {

        UsersManager usersManager = new UsersManager();

        Users newUser = new Users("Florent", "Password" ,"Mail@zerowaste.com", "06.06.06.06.06", 150, 0);

        usersManager.Insert(Users.class.getName(), newUser);
    }
}
