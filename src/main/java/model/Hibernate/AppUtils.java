package model.Hibernate;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AppUtils {

    public static Timestamp getTimestampForOneWeekAway() {
        LocalDateTime localTime = LocalDateTime.now();
        localTime = localTime.plusDays(7);

        return Timestamp.valueOf(localTime);
    }

    public static Timestamp getTimestampForTwoWeeksAway() {
        LocalDateTime localTime = LocalDateTime.now();
        localTime = localTime.plusDays(14);

        return Timestamp.valueOf(localTime);
    }
}
