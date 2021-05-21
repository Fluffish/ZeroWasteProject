package model.connectionManager;

import model.Hibernate.Tables.Users;
import model.Hibernate.TablesManager.UsersManager;
import model.UserUtilities;

public class Session {

    private static PasswordAuthentication PASSWORDAUTHENTICATION = new PasswordAuthentication();

    private Users user;
    private boolean connected;

    public UserUtilities utilities;

    public Session() {
        this.user = null;
        this.connected = false;

        this.utilities = null;
    }

    public Session(String username, String password) {
        UsersManager usersManager = new UsersManager();
        char[] passwordToCharArray = password.toCharArray();

        if(usersManager.usernameAlreadyUsed(username)) {
            if (PASSWORDAUTHENTICATION.authenticate(passwordToCharArray,
                                                    usersManager.getUsers(username).getPassword())) {
                this.user = usersManager.getUsers(username);
                this.connected = true;
                this.utilities = new UserUtilities(user);
            } else {
                this.user = null;
                this.connected = false;
            }
        } else {
            this.user = null;
            this.connected = false;
        }
    }

    public Users getUser() {
        return user;
    }

    public boolean isConnected() {
        return connected;
    }

    public void disconnect() {
        this.user = null;
        this.connected = false;
    }
}
