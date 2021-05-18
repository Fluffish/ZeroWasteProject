import connectionManager.PasswordAuthentication;

public class TestInsert {

    public static void main(String[] args) {
        PasswordAuthentication passwordAuthentication = new PasswordAuthentication(10);

        char[] password0 = {'m', 'a', 'y', 'u', 's'};
        char[] password1 = {'m', 'a', 'y', 'a', 's'};

        System.out.println(passwordAuthentication.authenticate(password0, passwordAuthentication.hash(password1)));
    }
}
