package labthree.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static String formatTime(long timeInMillis) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timeInMillis);
        return sdf.format(date);
    }
}
