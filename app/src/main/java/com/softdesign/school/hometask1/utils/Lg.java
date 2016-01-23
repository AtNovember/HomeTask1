package com.softdesign.school.hometask1.utils;

import android.util.Log;

/**
 * Зарефакторить код логера в соответствии с данными на лекции рекомендациями, исспользовать подход DRY Don’t repeat yourself (не повторяй себя) -
 * т.е. избегаем повторения уже ранее написанного кода + Javadoc,
 * логер должен исспользовать различные уровни вывода логов (Verbose, debug, info, error, warn, assert ).
 */
public class Lg {

    private static final String PREFIX = "LOGGER ";
    public static final int LOGCAT_BUFFER_SIZE = 3000;


    private Lg(){
    }

    /**
     * Метод проверяет, включены ли логи
     * */
    private static boolean shouldLog() {
//        return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
        return true;
    }

    /**
     * уровень вывода логов Verbose
     * */
    public static void v(String tag, String msg) {
        logger(Log.VERBOSE, tag, msg);
    }

    /**
     * уровень вывода логов Debug
     * */
    public static void d(String tag, String msg) {
        logger(Log.DEBUG, tag, msg);
    }

    /**
     * уровень вывода логов Info
     * */
    public static void i(String tag, String msg) {
        logger(Log.INFO, tag, msg);
    }

    /**
     * уровень вывода логов Error
     * */
    public static void e(String tag, String msg) {
        logger(Log.ERROR, tag, msg);
    }

    /**
     * уровень вывода логов Warn
     * */
    public static void w(String tag, String msg) {
        logger(Log.WARN, tag, msg);
    }

    /**
     * уровень вывода логов Assert
     * */
    public static void a(String tag, String msg) {
        logger(Log.ASSERT, tag, msg);
    }

    private static void logger (int level, String tag, String msg){
        if (shouldLog()) {
            String str = msg;
            while (str.length() > LOGCAT_BUFFER_SIZE){
                String substr = str.substring(0, LOGCAT_BUFFER_SIZE);
                str = substr.substring(LOGCAT_BUFFER_SIZE);
                Log.println(level, PREFIX + tag, str);
            }
            Log.println(level, PREFIX + tag, str);
        }
    }
}

