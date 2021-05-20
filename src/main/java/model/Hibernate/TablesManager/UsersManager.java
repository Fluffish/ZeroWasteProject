package model.Hibernate.TablesManager;

import model.Hibernate.Tables.Users;

import java.util.List;

public class UsersManager extends Manager<Users> {

    public Users findUserById(Integer id_user) {
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

    public Users getUsers(String username) {
        String sqlQuery = "SELECT x FROM Users x WHERE x.username = '" + username + "'";
        List<Users> result = MakeQuery(Users.class.getName(), sqlQuery);
        return result.get(0);
    }

    public boolean mailAlreadyUsed(String mailUser) {
        String sqlQuery = "SELECT x FROM Users x WHERE x.mail_user = '" + mailUser + "'";
        List<Users> result = MakeQuery(Users.class.getName(), sqlQuery);
        return result.size() != 0;
    }

    public boolean usernameAlreadyUsed(String username) {
        String sqlQuery = "SELECT x FROM Users x WHERE x.username = '" + username + "'";
        List<Users> result = MakeQuery(Users.class.getName(), sqlQuery);
        return result.size() != 0;
    }

}
