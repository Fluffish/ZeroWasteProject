import model.connectionManager.Session;
import model.connectionManager.SignUp;

public class TestInsert {

    public static void main(String[] args) {
        SignUp.createUser("abdou","abdou123","badou@gmail.com","09875435789",1001,100);
        Session session = new Session("abdou","abdou123");
        System.out.println(session.isConnected());
    }
}
