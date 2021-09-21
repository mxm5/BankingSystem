package utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;

public class Time {

    public Timestamp now() {
        return Timestamp.from(Instant.now());
    }

    public Date fourYearsFromNow(){

        Calendar cal = Calendar.getInstance();
        cal.setTime(now());
        cal.add(Calendar.YEAR, 4);
//        ts.setTime(cal.getTime().getTime()); // or
//        ts = new Timestamp(cal.getTime().getTime());
        return new Date(cal.getTime().getTime());
//        return new Timestamp(cal.getTime().getTime());
    }
}
