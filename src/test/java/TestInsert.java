import model.Hibernate.TablesManager.UsersManager;
import model.StorageRoom;
import model.UserUtilities;
import model.connectionManager.Session;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TestInsert {

    public static void main(String[] args) {
        UsersManager usersManager = new UsersManager();
        Session session = new Session("Mayas", "SuperMayas123");
        StorageRoom storageRoom = UserUtilities.getUserStorages(session.getUser());

//        UserUtilities.addUserPossess(session.getUser(), storageRoom.getElement(0).getIdStorage(), 10, "200g", Timestamp.valueOf(LocalDateTime.now()), 5);

        System.out.println(UserUtilities.getAllFood(session.getUser(), storageRoom));
    }
}
