package connectionManager;

import Hibernate.Tables.Users;
import Hibernate.TablesManager.UsersManager;

public class Session {

    private Users user;
    private boolean connected;

    public Session() {
        this.user = null;
        this.connected = false;
    }

    public Session(String username, String password) {
        UsersManager usersManager = new UsersManager();

        if(usersManager.usernameAlreadyUsed(username)) {
            if (usersManager.getUsers(username).getPassword().equals(password)) {
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
