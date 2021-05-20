import model.Hibernate.AppUtils;
import model.Hibernate.TablesManager.UsersManager;
import model.StorageRoom;
import model.UserUtilities;
import model.connectionManager.Session;

public class TestInsert {

    public static void main(String[] args) {
        UsersManager usersManager = new UsersManager();
        Session session = new Session("Mayas", "SuperMayas123");
        StorageRoom storageRoom = UserUtilities.getUserStorages(session.getUser());

//        UserUtilities.addUserPossess(session.getUser(), storageRoom.getElement(0).getIdStorage(), 2, "500g", AppUtils.getTimestampForTwoWeeksAway(), 5);

//        storageRoom = UserUtilities.getUserStorages(session.getUser());

        System.out.println(UserUtilities.getAvailableRecipes(session.getUser(), storageRoom));
    }
}
