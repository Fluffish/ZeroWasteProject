package connectionManager;

import Hibernate.Tables.Users;
import Hibernate.TablesManager.UsersManager;

public class SignUp {

    public static boolean createUser(String username,
                                  String password,
                                  String mail_user,
                                  String tel_user,
                                  Integer user_max_budget,
                                  Integer user_current_budget) {
        UsersManager usersManager = new UsersManager();

        if (usersManager.usernameAlreadyUsed(username)) {
            return false;
        }

        Users newUser = new Users(username, password, mail_user, tel_user, user_max_budget, user_current_budget);

        usersManager.Insert(Users.class.getName(), newUser);

        return true;
    }

}
