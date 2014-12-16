package com.falconraptor.utilities.logger;

import com.falconraptor.utilities.files.*;

import java.util.*;

public class Logger {
    public static final int ALL = 1;
    public static final int DEBUG = 3;
    public static final int ERROR = 5;
    public static final int WARNING = 4;
    public static final int INFO = 2;
    public static ArrayList<String> log = new ArrayList<>(0);
    public static int level = 3;
    public static Console console = new Console();

    public static void logALL (Object object) {
        if (level <= ALL) log("[ALL] ", object);
    }

    private static void log (String level, Object object) {
        String logitem = formatCalender(getCalendar()) + level + object.toString();
        System.out.println(logitem);
        log.add(logitem);
        if (!console.closed && console.isVisible()) console.updateConsole(logitem);
    }

    public static Calendar getCalendar () {
        return Calendar.getInstance();
    }

    public static String formatCalender (Calendar c) {
        return "[" + c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) + "]" + " [" + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "] ";
    }

    public static void logDEBUG(Object object) {
        if (level <= DEBUG) log("[DEBUG] ", object);
    }

    public static void logERROR(Object object) {
        if (level <= ERROR) log("[ERROR] ", object);
    }

    public static void logWARNING(Object object) {
        if (level <= WARNING) log("[WARNING] ", object);
    }

    public static void logINFO(Object object) {
        if (level <= INFO) log("[INFO] ", object);
    }

    public static void saveLog(String file) {
        Write.Write(file.substring(0, file.lastIndexOf(".")) + formatCalender(getCalendar()).substring(0, formatCalender(getCalendar()).lastIndexOf(":")).replaceAll(" ", "").replaceAll(":", ";") + "]" + file.substring(file.lastIndexOf(".")), false);
        Write.write(log);
        Write.close();
    }
}
