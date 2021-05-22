import model.Hibernate.AppUtils;
import model.Hibernate.TablesManager.UsersManager;
import model.connectionManager.Session;
import model.connectionManager.SignUp;

public class TestInsert {

    public static void main(String[] args) {
//        SignUp.createUser("Djursy", "djursybis", "djursy@gmail.com", "00 00 00 00 00", 500, 425);

        UsersManager usersManager = new UsersManager();
        Session session = new Session("Mayas", "SuperMayas123");

        session.utilities.addUserPossess(1, 2, "200g", AppUtils.getTimestampForOneWeekAway(), 5f);

        System.out.println(session.utilities.getAllFood());

        session.disconnect();

        session = new Session("Djursy", "djursybis");

        System.out.println(session.utilities.getAllFood());

        session.disconnect();

        System.out.println(session.isConnected());
    }
}
