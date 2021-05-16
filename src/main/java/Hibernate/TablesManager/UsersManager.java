package Hibernate.TablesManager;

import Hibernate.Tables.Users;
import java.util.List;

public class UsersManager extends Manager<Users> {

    public Users FindUserById(Integer id_user) {
        Connect(Users.class.getName());

        entityManager.getTransaction().begin();
        Users user = entityManager.find(Users.class,id_user);
        entityManager.getTransaction().commit();

        Disconnect();

        return user;
    }

    public Users FindUserByUsername(String username) {
        Connect(Users.class.getName());

        String sqlQuery = "SELECT x FROM Users x WHERE x.username = '" + username + "'";
        List<Users> users = MakeQuery(Users.class.getName(), sqlQuery);

        Disconnect();

        return users.get(0);
    }

    public Boolean UsernameAlreadyUsed(String username) {
        String sqlQuery = "SELECT x FROM Users x WHERE x.username = '" + username + "'";
        List<Users> result = MakeQuery(Users.class.getName(), sqlQuery);
        return result.size() != 0;
    }

}
