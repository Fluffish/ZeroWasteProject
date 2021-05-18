import Hibernate.AppUtils;
import Hibernate.Tables.User_Possess;
import Hibernate.TablesManager.UserPossessManager;

import java.sql.Timestamp;
import java.util.List;

public class TestInsert {

    public static void main(String[] args) {

        Timestamp testLimit = Timestamp.valueOf("2021-07-23 00:00:00");
        Timestamp testAdd = Timestamp.valueOf("2021-05-18 00:00:00");
/*
        UserPossessManager userPossessManager = new UserPossessManager();
        List<User_Possess> test = userPossessManager.FindVeryLimitedFood();

        for(User_Possess x : test) {
            System.out.println(x.getId_food());
        }
        */
    }
}
