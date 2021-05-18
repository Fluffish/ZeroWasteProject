package connectionManager;

import Hibernate.Tables.Users;
import Hibernate.TablesManager.UsersManager;

public class Session {

    private static PasswordAuthentication PASSWORDAUTHENTICATION = new PasswordAuthentication();

    private Users user;
    private boolean connected;

    public Session() {
        this.user = null;
        this.connected = false;
    }

    public Session(String username, String password) {
        UsersManager usersManager = new UsersManager();
        char[] passwordToCharArray = password.toCharArray();

        if(usersManager.usernameAlreadyUsed(username)) {
            if (PASSWORDAUTHENTICATION.authenticate(passwordToCharArray,
                                                    usersManager.getUsers(username).getPassword())) {
                this.user = usersManager.getUsers(username);
                this.connected = true;
            } else {
                this.user = null;
                this.connected = false;
            }
        } else {
            this.user = null;
            this.connected = false;
        }
    }

    public void disconnect() {
        this.user = null;
        this.connected = false;
    }
}
