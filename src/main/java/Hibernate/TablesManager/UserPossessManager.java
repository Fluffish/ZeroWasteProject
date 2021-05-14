package Hibernate.TablesManager;

import Hibernate.Tables.User_Possess;
import java.util.ArrayList;
import java.util.List;

public class UserPossessManager extends Manager<User_Possess> {

    public List<Integer> FindUserPossession(Integer id_user) {
        String sqlQuery = "SELECT x FROM User_Possess x WHERE x.id_user = " + id_user;
        List<User_Possess> possessedStorage = MakeQuery(User_Possess.class.getName(), sqlQuery);

        List<Integer> result = new ArrayList<>();

        for (User_Possess possess : possessedStorage) {
            result.add(possess.getId_storage());
        }
        return result;
    }

}
