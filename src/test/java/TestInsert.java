import Hibernate.Tables.*;
import Hibernate.TablesManager.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

        Timestamp time = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(time.toString());
        String timeString = time.toString();
        String[] timeLines = timeString.split(" ");
        String[] timeDate = timeLines[0].split("-");
        int day = Integer.parseInt(timeDate[2]);
        day = day + 7;

    }
}
