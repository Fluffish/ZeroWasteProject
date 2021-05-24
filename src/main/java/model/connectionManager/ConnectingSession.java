package model.connectionManager;

import model.Hibernate.Tables.Users;
import model.Hibernate.TablesManager.UsersManager;
import model.UsersUtilities;

public class ConnectingSession {

    private static UsersManager USER_MANAGER = new UsersManager();
    private static PasswordAuthentication   PASSWORDAUTHENTICATION = new PasswordAuthentication();

    private Users user;
    private boolean connected;

    public UsersUtilities utilities;

    public ConnectingSession() {
        this.user = null;
        this.connected = false;

        this.utilities = null;
    }

    public ConnectingSession(String username, String password) {
        UsersManager usersManager = new UsersManager();
        char[] passwordToCharArray = password.toCharArray();

        if(usersManager.usernameAlreadyUsed(username)) {
            if (PASSWORDAUTHENTICATION.authenticate(passwordToCharArray,
                                                    usersManager.getUsers(username).getPassword())) {
                this.user = usersManager.getUsers(username);
                this.connected = true;
                this.utilities = new UsersUtilities(user);
            } else {
                this.user = null;
                this.connected = false;
                this.utilities=null;
            }
        } else {
            this.user = null;
            this.connected = false;
            this.utilities=null;

        }
    }

    public Users getUser() {
        return user;
    }

    public void changeUsername(String username) {
        this.user.setUsername(username);

        USER_MANAGER.Merge(Users.class.getName(), user);
    }

    public void changePassword(String password) {
        char[] passwordToCharArray = password.toCharArray();

        String token = PASSWORDAUTHENTICATION.hash(passwordToCharArray);

        this.user.setPassword(token);

        USER_MANAGER.Merge(Users.class.getName(), user);
    }

    public void changeMail(String mail) {
        this.user.setMail_user(mail);

        USER_MANAGER.Merge(Users.class.getName(), user);
    }

    public void changePhone(String phone) {
        this.user.setTel_user(phone);

        USER_MANAGER.Merge(Users.class.getName(), user);
    }

    public void changeMaxBudget(int budget) {
        this.user.setUser_max_budget(budget);

        USER_MANAGER.Merge(Users.class.getName(), user);
    }

    public void changeCurrentBudget(int budget) {
        this.user.setUser_current_budget(budget);

        USER_MANAGER.Merge(Users.class.getName(), user);
    }

    public boolean isConnected() {
        return connected;
    }

    public void disconnect() {
        this.user = null;
        this.connected = false;
        this.utilities = null;
    }
}
